class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency list:
        // graph[u] contains {v, travelTime}
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int node = 1; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }

        // Build the directed graph
        for (int[] edge : times) {

            int sourceNode = edge[0];
            int targetNode = edge[1];
            int travelTime = edge[2];

            graph[sourceNode].add(
                new int[]{targetNode, travelTime}
            );
        }

        // shortestTime[node] = shortest time from k to node
        int[] shortestTime = new int[n + 1];

        Arrays.fill(shortestTime, Integer.MAX_VALUE);

        // {time, node}
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(state -> state[0])
        );

        shortestTime[k] = 0;
        priorityQueue.offer(new int[]{0, k});

        while (!priorityQueue.isEmpty()) {

            int[] currentState = priorityQueue.poll();

            int currentTime = currentState[0];
            int currentNode = currentState[1];

            // Ignore outdated entry
            if (currentTime > shortestTime[currentNode]) {
                continue;
            }

            // Explore all outgoing edges
            for (int[] edge : graph[currentNode]) {

                int nextNode = edge[0];
                int travelTime = edge[1];

                int newTime = currentTime + travelTime;

                // Found a shorter path to nextNode
                if (newTime < shortestTime[nextNode]) {

                    shortestTime[nextNode] = newTime;

                    priorityQueue.offer(
                        new int[]{newTime, nextNode}
                    );
                }
            }
        }

        // The signal reaches everyone only when every node
        // has a finite shortest time.
        int maximumTime = 0;

        for (int node = 1; node <= n; node++) {

            if (shortestTime[node] == Integer.MAX_VALUE) {
                return -1;
            }

            maximumTime = Math.max(
                maximumTime,
                shortestTime[node]
            );
        }

        return maximumTime;
    }
}