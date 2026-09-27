class Solution {
    public int mySqrt(int x) {
        int l=0,r=x;
        int res=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((mid*mid)>x){
                r=mid-1;
            }else if((mid*mid)<x){
                l=mid+1;
                res=mid;
            }else{
                return mid;
            }
        }
        return res;
    }
}