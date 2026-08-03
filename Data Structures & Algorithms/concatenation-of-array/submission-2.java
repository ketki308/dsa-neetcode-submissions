class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length*2;
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            if(i>nums.length-1){
                ans[i]=nums[i-nums.length];
            }else{
            ans[i]=nums[i];}
        }
        return ans;
    }
}