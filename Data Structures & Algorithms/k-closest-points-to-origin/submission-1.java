class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap=new PriorityQueue<>(
            (a,b)->distance(b)-distance(a)
        );

        for(int[] point:points){
            maxheap.offer(point);
            if(maxheap.size()>k){
                maxheap.poll();
            }
        }
        int res[][]=new int[k][2];
        int i=0;
        while(!maxheap.isEmpty()){
            res[i++]=maxheap.poll();
        }
        return res;
    }
    private int distance(int[] p){
        return p[0]*p[0]+p[1]*p[1];
    }
}
