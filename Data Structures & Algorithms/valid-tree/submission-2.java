class Solution {
    public boolean validTree(int n, int[][] edges) {
        // List<List<Integer>> graph=new ArrayList<>();

        // for(int i=0;i<n;i++){
        //     graph.add(new ArrayList<>());
        // }

        // for(int[] edge:edges){
        //     int a=edge[0];
        //     int b=edge[1];

        //     graph.get(a).add(b);
        // }

        // if(graph.size()<n){
        //     return true;
        // }

        // return false;

        if(edges.length<n){
            return true;
        }

        return false;
    }
}
