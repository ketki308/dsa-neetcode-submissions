class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0;
        int maxfreq=0;
        int maxlongest=0;
        for(int right=0;right<s.length();right++){
            int index=s.charAt(right)-'A';
            freq[index]++;
            maxfreq=Math.max(maxfreq,freq[index]);
            
            while((right-left+1)-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxlongest=Math.max(maxlongest,right-left+1);
        }   
        return maxlongest;
    }
}
