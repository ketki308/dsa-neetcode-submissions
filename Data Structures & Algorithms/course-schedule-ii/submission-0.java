class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> prereq=new HashMap<>();
        for(int[] pair:prerequisites){
            prereq.computeIfAbsent(pair[0],
                   k->new ArrayList<>()).add(pair[1]);
        }
        Set<Integer> cycle=new HashSet<>();
        Set<Integer> visited=new HashSet<>();
        List<Integer> output=new ArrayList<>();
        for(int courses=0;courses<numCourses;courses++){
            if(!dfs(courses,prereq,visited,cycle,output)){
                return new int[0];
            }
        }
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=output.get(i);
        }

        return result;
    }
    private boolean dfs(int courses,Map<Integer,List<Integer>> prereq,Set<Integer> visited,Set<Integer> cycle,List<Integer> output){
        if(cycle.contains(courses)){
            return false;
        }
        if(visited.contains(courses)){
            return true;
        }
        cycle.add(courses);

        for(int pre:prereq.getOrDefault(courses,Collections.emptyList())){
            if(!dfs(pre,prereq,visited,cycle,output)){
                return false;
            }
        }
        cycle.remove(courses);
        visited.add(courses);
        output.add(courses);
        return true;
    }
}
