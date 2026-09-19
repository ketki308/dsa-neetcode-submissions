class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();

        return solve(0, s, dict, memo);
    }

    private List<String> solve(int start, String s,
                               Set<String> dict,
                               Map<Integer, List<String>> memo) {

        if (start == s.length()) {
            return List.of("");
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (!dict.contains(word)) {
                continue;
            }

            List<String> remaining = solve(end, s, dict, memo);

            for (String sentence : remaining) {
                if (sentence.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(word + " " + sentence);
                }
            }
        }

        memo.put(start, result);
        return result;
    }
}