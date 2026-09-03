class Solution {
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return isPalindrome(s.substring(0,1)+s.substring(l+1)) ||
                isPalindrome(s.substring(0,r)+s.substring(r+1));
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}