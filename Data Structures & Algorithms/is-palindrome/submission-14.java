class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        int left=0,right=s.length()-1;
        while(left<=right){
            while(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
