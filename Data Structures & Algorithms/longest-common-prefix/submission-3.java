class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null) return "";
        String prev=strs[0];
        for(int i=1;i<strs.length;i++){
            String s=strs[i];
            int j=0;
            while(j<prev.length() && j<s.length() && prev.charAt(j)==s.charAt(j)){
                j++;
            }
            prev=prev.substring(0,j);
            if(prev.isEmpty()) return "";
        }
        return prev;
    }
}