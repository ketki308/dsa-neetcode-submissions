class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;

        for(int i=0;i<s.length();i++){
            count+=fun(s,i,i);
            count+=fun(s,i,i+1);
        }
        return count;
    }
    private int fun(String s,int a,int b){
        int cnt=0;
        while(a>=0 && b<s.length() && s.charAt(a)==s.charAt(b)){
            cnt++;
            a--;
            b++;
        }
        return cnt;
    }
}
