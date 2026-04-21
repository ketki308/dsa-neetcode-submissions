class Solution {
    public int search(int[] nums, int target) {
        return rec(nums,0,nums.length-1,target);
    }
    private int rec(int[] nums,int left,int right,int target){
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;

        // left half sorted
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                return rec(nums, left, mid - 1, target);
            } else {
                return rec(nums, mid + 1, right, target);
            }
        }
        // right half sorted
        else {
            if (target > nums[mid] && target <= nums[right]) {
                return rec(nums, mid + 1, right, target);
            } else {
                return rec(nums, left, mid - 1, target);
            }
        }
    }
}
