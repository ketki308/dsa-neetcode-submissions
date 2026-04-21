class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        while(left<nums.length-1){
            int i=left+1;
            if(nums[left]==nums[i]) return true;

            left++;
        }
        return false;
    }
}