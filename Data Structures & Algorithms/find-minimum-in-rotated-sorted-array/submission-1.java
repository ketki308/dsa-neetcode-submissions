class Solution {
    public int findMin(int[] nums) {
        return rec(nums,0,nums.length-1);
    }
    private int rec(int[] nums,int left,int right){
        if(nums[left]<=nums[right]) return nums[left];

        int mid=left+(right-left)/2;
        if(nums[mid]>nums[right]){
            return rec(nums,mid+1,right);
        }else{
            return rec(nums,left,mid);
        }
    }
}
