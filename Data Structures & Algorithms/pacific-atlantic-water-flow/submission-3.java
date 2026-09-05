class Solution {

    int[][] directions = {
        {-1, 0},  // up
        {1, 0},   // down
        {0, -1},  // left
        {0, 1}    // right
    };

    void bfs(
        int startRow,
        int startCol,
        boolean[][] vis,
        int[][] heights
    ) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startRow, startCol});
        vis[startRow][startCol] = true;

        int m = heights.length;
        int n = heights[0].length;

        while (!q.isEmpty()) {

            int[] current = q.remove();

            int currentRow = current[0];
            int currentCol = current[1];

            for (int[] direction : directions) {

                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                // Check whether the next cell is inside the grid
                // and whether we can move to it in reverse direction.
                if (
                    nextRow >= 0 && nextRow < m &&
                    nextCol >= 0 && nextCol < n &&
                    !vis[nextRow][nextCol] &&
                    heights[nextRow][nextCol] >= heights[currentRow][currentCol]
                ) {

                    vis[nextRow][nextCol] = true;
                    q.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        // Left edge → Pacific
        // Right edge → Atlantic
        for (int row = 0; row < m; row++) {

            bfs(row, 0, pacificReachable, heights);

            bfs(row, n - 1, atlanticReachable, heights);
        }

        // Top edge → Pacific
        // Bottom edge → Atlantic
        for (int col = 0; col < n; col++) {

            bfs(0, col, pacificReachable, heights);

            bfs(m - 1, col, atlanticReachable, heights);
        }

        // A cell belongs in the answer if it can reach both oceans.
        for (int row = 0; row < m; row++) {

            for (int col = 0; col < n; col++) {

                if (pacificReachable[row][col] &&
                    atlanticReachable[row][col]) {

                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }
}