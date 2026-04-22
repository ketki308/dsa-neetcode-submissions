class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        dfs(s,0,new ArrayList<>(),res);
        return res;
    }
    private void dfs(String s,int ind,List<String> ds,List<List<String>> res){
        if(ind==s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                dfs(s,i+1,ds,res);
                ds.remove(ds.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
