class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();

        int start=newInterval[0];
        int end=newInterval[1];

        for(int[] interval:intervals){
            if(interval[1]<start){
                res.add(interval);
            }
            else if(interval[0]>end){
                res.add(new int[]{start,end});
                start=interval[0];
                end=interval[1];
            }
            else{
                start=Math.min(start,interval[0]);
                end=Math.max(end,interval[1]);
            }
        }
        res.add(new int[]{start,end});

        return res.toArray(new int[res.size()][]);
    }
}
