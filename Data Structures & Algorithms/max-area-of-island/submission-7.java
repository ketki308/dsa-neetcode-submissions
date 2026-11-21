class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j);
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;

        if(i>=m || j>=n || i<0 || j<0 || grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;

        int count=1;

        count+=dfs(grid,i+1,j);
        count+=dfs(grid,i-1,j);
        count+=dfs(grid,i,j+1);
        count+=dfs(grid,i,j-1);

        return count;
    }
}
