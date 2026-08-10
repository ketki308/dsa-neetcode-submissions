class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];

        // Store the position of each character
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String a = words[i];
            String b = words[i + 1];

            int j = 0;

            while (j < a.length() && j < b.length()) {

                if (a.charAt(j) != b.charAt(j)) {

                    if (rank[a.charAt(j) - 'a'] >
                        rank[b.charAt(j) - 'a']) {

                        return false;
                    }

                    // First different character determines ordering
                    break;
                }

                j++;
            }

            // b is a prefix of a
            if (j == b.length() && a.length() > b.length()) {
                return false;
            }
        }

        return true;
    }
}