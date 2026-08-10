class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] count = new int[26];

        // Frequency of characters in chars
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }

        int answer = 0;

        for (String word : words) {

            int[] available = count.clone();
            boolean good = true;

            for (char c : word.toCharArray()) {

                if (available[c - 'a'] == 0) {
                    good = false;
                    break;
                }

                available[c - 'a']--;
            }

            if (good) {
                answer += word.length();
            }
        }

        return answer;
    }
}