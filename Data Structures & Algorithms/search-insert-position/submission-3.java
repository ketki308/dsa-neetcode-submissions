class Solution {
    public int searchInsert(int[] nums, int target) {
        int res=nums.length;
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                res=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return res;
    }
}