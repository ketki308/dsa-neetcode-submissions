class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prev=strs[0];
        for(int i=1;i<strs.length;i++){
            String c=strs[i];
            int j=0;
            while(j<prev.length() && j<c.length() && prev.charAt(j)==c.charAt(j)){
                j++;
            }
            prev=prev.substring(0,j);
            if(prev.isEmpty()) return "";
        }
        return prev;
    }
}