class Solution {
    public long maximumSumScore(int[] nums) {
        long prefix=nums[0];
        long sufix=nums[nums.length-1];
        long maxcount=0;

        for(int i=1;i<nums.length-1;i++){
            prefix=Math.max(prefix,prefix+nums[i]);
            maxcount=Math.max(prefix,sufix);
        }
        return maxcount;
    }
}
