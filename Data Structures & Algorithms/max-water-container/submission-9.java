class Solution {
    public int maxArea(int[] heights) {
        int left=0,right=heights.length-1;
        int longest=0;
        while(left<right){
            int water=Math.min(heights[left],heights[right])*(right-left);
            longest=Math.max(longest,water);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return longest;
    }
}
