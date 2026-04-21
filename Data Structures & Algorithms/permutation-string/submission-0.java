class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];

        if(s1.length()>s2.length()) return false;

        for(char c:s1.toCharArray()){
            freq[c-'a']++;}

        int left=0;
        for(int right=0;right<s2.length();right++){
            char rc=s2.charAt(right);
            freq[rc-'a']--;

            while(freq[rc-'a']<0){
                char lc=s2.charAt(left);
                freq[lc-'a']++;
                left++;
            }
            if(right-left+1==s1.length()){
                return true;
            }
        }
        return false;
    }
}
