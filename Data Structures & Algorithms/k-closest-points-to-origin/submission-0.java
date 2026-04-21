class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(
            (a,b)->distance(b)-distance(a)
        );

        for(int point[]:points){
            maxHeap.offer(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int res[][]=new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            res[i++]=maxHeap.poll();
        }
        return res;
    }
    private int distance(int[] p){
        return p[0]*p[0]+p[1]*p[1];
    }
}
