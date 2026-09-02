class Solution {
    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {

        // Outside the grid = one perimeter edge
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length) {
            return 1;
        }

        // Water = one perimeter edge
        if (grid[i][j] == 0) {
            return 1;
        }

        // Already visited land
        if (grid[i][j] == 2) {
            return 0;
        }

        // Mark visited
        grid[i][j] = 2;

        int perimeter = 0;

        perimeter += dfs(grid, i - 1, j); // up
        perimeter += dfs(grid, i + 1, j); // down
        perimeter += dfs(grid, i, j - 1); // left
        perimeter += dfs(grid, i, j + 1); // right

        return perimeter;
    }
}