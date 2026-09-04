class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left=0,right=nums.length-1;
        while(left<right){
            if(Math.abs(left-right)<=k && nums[left]==nums[right]){
                return true;
            }
            left++;
            right--;
        }
        return false;
    }
}