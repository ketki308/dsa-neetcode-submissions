class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming=new int[n+1];
        int[] outgoing=new int[n+1];

        for(int[] t:trust){
            incoming[t[1]]++;
            outgoing[t[0]]++;
        }

        for(int i=0;i<n;i++){
            if(incoming[i]==n-1 && outgoing[i]==0){
                return i;
            }
        }
        return -1;
    }
}