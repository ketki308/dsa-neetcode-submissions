class Solution {
    public int maxProduct(int[] nums) {
        int res=Integer.MIN_VALUE;

        for(int n:nums){
            res=Math.max(res,n);
        }
        int currmax=1,currmin=1;
        for(int n:nums){
            int temp=currmax*n;
            currmax=Math.max(temp,Math.max(currmin*n,n));
            currmin=Math.min(temp,Math.min(currmin*n,n));
            res=Math.max(res,currmax);
        }
        return res;
    }
}
