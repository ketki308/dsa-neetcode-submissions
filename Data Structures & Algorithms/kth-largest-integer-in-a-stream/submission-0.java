class KthLargest {

    private PriorityQueue<Integer> minheap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minheap=new PriorityQueue<>();

        for(int num:nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(minheap.size()<k){
            minheap.offer(val);
        }else if(val>minheap.peek()){
            minheap.poll();
            minheap.offer(val);
        }
        return minheap.peek();
    }
}
