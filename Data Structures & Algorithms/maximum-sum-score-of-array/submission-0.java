class Solution {
    public long maximumSumScore(int[] nums) {
        long maxcount=nums[0];

        for(int i=1;i<nums.length;i++){
            maxcount=Math.max(maxcount+nums[i],nums[i]);
        }

        return maxcount;
    }
}
