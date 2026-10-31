class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];
        for(int[] pre:prerequisites){
            int prereq=pre[0];
            int course=pre[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        } 
        boolean[][] isprereq=new boolean[numCourses][numCourses];

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            
            for(int next:graph.get(curr)){
                isprereq[curr][next]=true;

                for(int i=0;i<numCourses;i++){
                    if(isprereq[i][curr]){
                        isprereq[i][next]=true;
                    }
                }
                indegree[next]--;

                if(indegree[next]==0){
                    q.offer(next);
                }

            }
        }

        List<Boolean> ans=new ArrayList<>();
        for(int[] query:queries){
            ans.add(isprereq[query[0]][query[1]]);
        }

        return ans;
    }
}