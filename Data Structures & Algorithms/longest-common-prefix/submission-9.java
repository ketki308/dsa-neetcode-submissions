class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            String word=strs[i];

            while(j<prefix.length() && j<word.length()){
                if(word.length()==0 || prefix.length()==0){
                    prefix="";
                }
                if(prefix.charAt(j)!=word.charAt(j)){
                    prefix=prefix.substring(0,j);
                }
                j++;
            }
        }

        return prefix;
    }
}