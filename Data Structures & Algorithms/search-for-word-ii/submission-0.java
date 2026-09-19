class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        // Out of bounds
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        // Already visited
        if (ch == '#') {
            return;
        }

        int index = ch - 'a';

        // Character doesn't continue any dictionary word
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        // Mark current cell as visited
        board[r][c] = '#';

        // Explore four directions
        dfs(board, r + 1, c, next); // down
        dfs(board, r - 1, c, next); // up
        dfs(board, r, c + 1, next); // right
        dfs(board, r, c - 1, next); // left

        // Backtrack
        board[r][c] = ch;
    }
}