class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];

        for(int i=1;i<strs.length;i++){
            String word=strs[i];
            int j=0;

            while(j<prefix.length() && j<word.length()){
            if(prefix.charAt(j)==word.charAt(j)){
                j++;
            }
            else{
                break;
            }
            }
            prefix=prefix.substring(0,j);
        }

        return prefix;
    }
}