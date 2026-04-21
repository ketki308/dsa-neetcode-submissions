class Solution {
    public int findMin(int[] nums) {
        return res(nums,0,nums.length-1);
    }
    public int res(int[] nums,int left,int right){
        if(nums[left]<=nums[right]) return nums[left];

        int mid=left+(right-left)/2;
        if(nums[mid]>nums[right]){
            return res(nums,mid+1,right);
        }else{
            return res(nums,left,mid);
        }
    }
}
