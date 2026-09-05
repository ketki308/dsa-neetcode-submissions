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
        boolean[][] reachable,
        int[][] heights
    ) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startRow, startCol});
        reachable[startRow][startCol] = true;

        int rows = heights.length;
        int cols = heights[0].length;

        while (!queue.isEmpty()) {

            int[] current = queue.remove();

            int currentRow = current[0];
            int currentCol = current[1];

            for (int[] direction : directions) {

                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                // Check whether the next cell is inside the grid
                // and whether we can move to it in reverse direction.
                if (
                    nextRow >= 0 && nextRow < rows &&
                    nextCol >= 0 && nextCol < cols &&
                    !reachable[nextRow][nextCol] &&
                    heights[nextRow][nextCol] >= heights[currentRow][currentCol]
                ) {

                    reachable[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Left edge → Pacific
        // Right edge → Atlantic
        for (int row = 0; row < rows; row++) {

            bfs(row, 0, pacificReachable, heights);

            bfs(row, cols - 1, atlanticReachable, heights);
        }

        // Top edge → Pacific
        // Bottom edge → Atlantic
        for (int col = 0; col < cols; col++) {

            bfs(0, col, pacificReachable, heights);

            bfs(rows - 1, col, atlanticReachable, heights);
        }

        // A cell belongs in the answer if it can reach both oceans.
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (pacificReachable[row][col] &&
                    atlanticReachable[row][col]) {

                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }
}