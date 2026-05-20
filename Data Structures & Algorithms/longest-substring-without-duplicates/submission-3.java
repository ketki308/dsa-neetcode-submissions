class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> res=new HashSet<>();
        int left=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            while(res.contains(c)){
                res.remove(s.charAt(left));
                left++;
            }
            res.add(c);
            count=Math.max(count,i-left+1);
        }  
        return count;
    }
}
