class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited=new boolean[n];

        if(hasCycle(0,-1,graph,visited)){
            return false;
        }

        for(boolean nodevisited:visited){
            if(!nodevisited){
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(int node,int parent,List<List<Integer>> graph,boolean[] visited){
        visited[node]=true;
        for(int neighbor:graph.get(node)){
            if(neighbor==parent){
                continue;
            }
            if(visited[neighbor]){
                return true;
            }
            if(hasCycle(neighbor,node,graph,visited)){
                return true;
            }
        }
        return false;
    }
}
