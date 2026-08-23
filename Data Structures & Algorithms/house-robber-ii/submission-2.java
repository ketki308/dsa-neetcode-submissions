class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int case1=fun(nums,0,nums.length-2);
        int case2=fun(nums,1,nums.length-1);

        return Math.max(case2,case1);
    }

    private int fun(int[] nums,int start,int end){
        int prev2=0,prev1=0;
        for(int i=start;i<=end;i++){
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}
