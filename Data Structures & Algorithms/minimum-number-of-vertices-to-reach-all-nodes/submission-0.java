class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int v = edge[1];
            indegree[v]++;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}