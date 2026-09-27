class Solution {
    public int search(int[] nums, int target) {
        return fun(nums,0,nums.length-1,target);
    }
    private int fun(int[] nums,int left,int right,int target){
        if(left>right) return -1;
        int mid=left+(right-left)/2;
        if(nums[mid]==target) return mid;

        if(nums[left]<=nums[mid]){
            if(nums[left]<=target && nums[mid]>target){
                return fun(nums,left,mid-1,target);
            }else{
                return fun(nums,mid+1,right,target);
            }
        }
        else{
            if(nums[mid]<target && nums[right]>=target){
                return fun(nums,mid+1,right,target);
            }else{
                return fun(nums,left,mid-1,target);
            }
        }
    }
}
