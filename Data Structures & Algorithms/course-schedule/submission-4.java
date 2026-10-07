class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree=new int[numCourses];
        for(int[] pre:prerequisites){
            int courses=pre[0];
            int prereq=pre[1];
            graph.get(prereq).add(courses);
            inDegree[courses]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        int completed=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            completed++;
            for(int next:graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    q.offer(next);
                }
            }
        }
        return completed==numCourses;
    }
}
