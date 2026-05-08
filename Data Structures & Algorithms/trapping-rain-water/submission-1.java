class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,total=0;
        int lmax=height[left],rmax=height[right];
        while(left<right){
            if(lmax<rmax){
                left++;
                lmax=Math.max(lmax,height[left]);
                total+=lmax-height[left];
            }else{
                right--;
                rmax=Math.max(rmax,height[right]);
                total+=rmax-height[right];
            }
        }
        return total;
    }
}
