class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];

        for(int task:tasks){
            freq[task-'A']++;
        }
        int maxfreq=0;
        for(int f:freq){
            maxfreq=Math.max(maxfreq,f);
        }

        int countmaxfreq=0;
        for(int f:freq){
            if(f==maxfreq){
                countmaxfreq++;
            }
        }
        return Math.max(tasks.length,(maxfreq-1)*(n+1)+countmaxfreq);
    }
}
