class Solution {
    public int mySqrt(int x) {
        int res=0;
        int left=0,right=x;
        while(left<=right){
            int mid=left+(right-left)/2;

            if((long) mid*mid>x){
                right=mid-1;
            }else if((long) mid*mid<x){
                left=mid+1;
                res=mid;
            }else{
                return mid;
            }
        }
        return res;
    }
}