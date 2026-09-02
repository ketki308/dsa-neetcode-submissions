class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null) return "";

        String prev=strs[0];
        for(int i=1;i<strs.length;i++){
            String s=strs[i];
            int j=0;
            while(j<s.length() && j<prev.length() && s.charAt(j)==prev.charAt(j)){
                j++;
            }
            prev=prev.substring(0,j);
            if(prev.isEmpty()) return "";
       }
       return prev;
    }
}