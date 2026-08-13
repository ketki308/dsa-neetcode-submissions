class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int left=0,maxlen=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c) && map.get(c)>=left){
                left=map.get(c)+1;
            }
            maxlen=Math.max(maxlen,i-left+1);
            map.put(c,i);
        }
        return maxlen;
    }
}
