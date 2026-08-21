class Solution {

    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

        // Initially, every node is its own component
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (union(u, v)) {
                components--;
            }
        }

        return components;
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        // Already connected
        if (rootA == rootB) {
            return false;
        }

        // Union by rank
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } 
        else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } 
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }
}