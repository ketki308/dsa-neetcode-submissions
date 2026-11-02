class Solution {
    public int countComponents(int n, int[][] edges) {
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

        int total=0;
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                q.offer(i);
                visited[i]=true;
                total++;
            }
            
            while(!q.isEmpty()){
            int curr=q.poll();
            visited[curr]=true;

            for(int next:graph.get(curr)){
                if(!visited[next]){
                    q.offer(next);
                    visited[next]=true;
                }
            }
        }
        }

        return total;
    }
}
