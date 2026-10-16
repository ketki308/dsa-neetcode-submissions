class Solution {
    private List<List<Integer>> adj;
    private Set<Integer> cycle;
    private int cyclestart;
    private boolean[] visit;
    public int[] findRedundantConnection(int[][] edges) {
        adj=new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        cyclestart=-1;
        cycle=new HashSet<>();
        visit=new boolean[edges.length+1];
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
        if(visit[node]){
            cyclestart=node;
            return true;
        }
        visit[node]=true;

        for(int neighbor:adj.get(node)){
            if(neighbor==parent) continue;
            if(dfs(neighbor,node)){
                if(cyclestart!=-1) cycle.add(node);
                if(cyclestart==node){
                    cyclestart=-1;
                }
                return true;
            }
        }
        return false;
    }
}
