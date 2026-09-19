class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        int n = s.length();

        Set<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }

        int[] dp = new int[n + 1];

        // Worst case: every character is extra
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {

            // Option 1: leave s[i] as an extra character
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            // Option 2: use a dictionary word starting at i
            for (int j = i + 1; j <= n; j++) {

                String substring = s.substring(i, j);

                if (set.contains(substring)) {
                    dp[j] = Math.min(dp[j], dp[i]);
                }
            }
        }

        return dp[n];
    }
}