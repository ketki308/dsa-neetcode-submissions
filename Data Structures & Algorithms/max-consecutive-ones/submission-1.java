class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi=0;
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=1){
                k=i+1;
            }
            else{
                maxi=Math.max(maxi,i-k+1);
            }
        }
        return maxi;
    }
}