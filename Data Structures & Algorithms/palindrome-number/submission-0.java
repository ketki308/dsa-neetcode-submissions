class Solution {
    public boolean isPalindrome(int x) {
        int temp=Math.abs(x);
        int res=0;
        while(temp!=0){
            res=(res*10)+temp%10;
            temp/=10;
        }
        return res==x;
    }
}