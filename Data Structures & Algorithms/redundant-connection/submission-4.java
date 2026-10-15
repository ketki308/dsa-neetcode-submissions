class Solution {
    private List<List<Integer>> adj;
    private int cyclestart;
    private Set<Integer> cycle;
    private boolean[] visited;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        cyclestart=-1;
        visited=new boolean[n+1];
        cycle=new HashSet<>();
        dfs(1,-1);

        for(int i=edges.length-1;i>=0;i--){
            int u=edges[i][0],v=edges[i][1];
            if(cycle.contains(u) && cycle.contains(v)){
                return new int[]{u,v};
            }
        }

        return new int[0];
    }
    private boolean dfs(int node,int parent){
        if(visited[node]){
            cyclestart=node;
            return true;
        }
        visited[node]=true;

        for(int neighbor:adj.get(node)){
            if (neighbor==parent) continue;
            if(dfs(neighbor,node)){
                if(cyclestart!=-1) cycle.add(node);
                if(node==cyclestart){
                    cyclestart=-1;
                }
                return true;
            }
        }
        return false;
    }
}
