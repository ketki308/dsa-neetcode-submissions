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

        Queue<Integer> q=new LinkedList<>();
        

        boolean[] visited=new boolean[n];

        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                q.offer(i);
            
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
        }

        return count;
    }
}
