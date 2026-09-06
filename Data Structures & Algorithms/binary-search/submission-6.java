class Solution {
    public int search(int[] nums, int target) {
        if(nums.length<=1) return nums[0];
        int i=0,j=nums.length-1;
        while(i<j){
            int mid=i+(j-i)/2;

            if(nums[mid]==target) {
                return mid;
                }
            else if(nums[mid]<target){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return -1;
    }
}
