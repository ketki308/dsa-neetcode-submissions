class Solution {
    public String foreignDictionary(String[] words) {
        // 1. Create all characters first
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // 2. Build edges using adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int minLength = Math.min(w1.length(), w2.length());

            boolean foundDifference = false;

            for (int j = 0; j < minLength; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);

                    foundDifference = true;
                    break;
                }
            }

            // Invalid prefix case
            if (!foundDifference && w1.length() > w2.length()) {
                return "";
            }
        }

        // 3. Topological sort
        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char current = queue.poll();
            result.append(current);

            for (char next : graph.get(current)) {

                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // 4. Cycle detection
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
