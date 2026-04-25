class Solution {
    public int jump(int[] nums) {
        int fastest=0;
        int currentheight=0;
        int jump=0;

        for(int i=0;i<nums.length-1;i++){
            fastest=Math.max(fastest,i+nums[i]);
            if(i==currentheight){
                jump++;
                currentheight=fastest;
            }
        }
        return jump;
    }
}
