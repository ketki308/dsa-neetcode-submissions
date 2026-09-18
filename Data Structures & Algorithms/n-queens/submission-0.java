class Solution {
    List<List<String>> res = new ArrayList<>();

    public void solve(int n, int row, int[] queens, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] rowArr = new char[n];
                Arrays.fill(rowArr, '.');
                rowArr[queens[i]] = 'Q';
                board.add(new String(rowArr));
            }
            res.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row + col] || diag2[row - col + n - 1]) continue;
            queens[row] = col;
            cols[col] = diag1[row + col] = diag2[row - col + n - 1] = true;
            solve(n, row + 1, queens, cols, diag1, diag2);
            cols[col] = diag1[row + col] = diag2[row - col + n - 1] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        solve(n, 0, new int[n], new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
        return res;
    }
}
 