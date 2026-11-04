class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        if(edges.length!=n-1) return false;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<=n;i++){
            if(!visited[i]){
                q.offer(i);
                visited[i]=true;
            }

            while(!q.isEmpty()){
                int curr=q.poll();

                for(int next:graph.get(curr)){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next]=true;
                    }
                }
            }
            return true;
        }

        return false;
    }
}
