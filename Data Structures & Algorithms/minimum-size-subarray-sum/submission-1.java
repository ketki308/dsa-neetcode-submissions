class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        int minvalue=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];

            while(sum>=target){
                minvalue=Math.min(minvalue,right-left+1);

                sum-=nums[left];
                left++;
            }
        }
        return minvalue==Integer.MAX_VALUE?0:minvalue;
    }
}