class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

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
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        int count=0;

        while(!q.isEmpty()){
            int curr=q.poll();
            for(int next:graph.get(curr)){
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(next);
                    count++;
                }
            }
        }

        return n-1==count;

    }
}
