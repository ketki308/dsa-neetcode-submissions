class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
        for(int p:piles){
            right=Math.max(right,p);
        }
        int ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(canFinish(piles,h,mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    private boolean canFinish(int[] piles,int h,int k){
        int totalhours=0;
        for(int p:piles){
            totalhours+=(p+k-1)/k;
        }
        return totalhours<=h;
    }
}
