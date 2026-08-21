class Solution {
    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }

        // Make sure every node was reached
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
            int node,
            int parent,
            List<List<Integer>> graph,
            boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            // Ignore the edge we came from
            if (neighbor == parent) {
                continue;
            }

            // Already visited → cycle
            if (visited[neighbor]) {
                return true;
            }

            if (hasCycle(neighbor, node, graph, visited)) {
                return true;
            }
        }

        return false;
    }
}