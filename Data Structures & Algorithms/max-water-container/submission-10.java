class Solution {
    public int maxArea(int[] heights) {
        int maxwater=0;
        int i=0;
        int j=heights.length-1;

        while(i<=j){
            int water=Math.min(heights[i],heights[j])*(j-i);
            maxwater=Math.max(maxwater,water);

            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxwater;
    }
}
