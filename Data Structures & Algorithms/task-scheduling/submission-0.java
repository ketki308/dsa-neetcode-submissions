class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int countMaxFreq = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                countMaxFreq++;
            }
        }

        return Math.max(
            tasks.length,
            (maxFreq - 1) * (n + 1) + countMaxFreq
        );
    }
}