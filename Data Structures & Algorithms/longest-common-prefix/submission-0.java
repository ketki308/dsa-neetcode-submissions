class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";

        String pref=strs[0];
        for(int i=1;i<strs.length;i++){
            String s=strs[i];
            int j=0;
            while(j<pref.length() && j<s.length() && pref.charAt(j)==s.charAt(j)){
                j++;
            }
            pref=pref.substring(0,j);
            if(pref.isEmpty()) return "";
        }
        return pref;
    }
}