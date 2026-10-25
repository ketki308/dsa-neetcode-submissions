class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxcount=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    maxcount=Math.max(maxcount,dfs(grid,i,j));
                }
            }
        }
        return maxcount;
    }
    private int dfs(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        int count=1;

        if(i>=m || j>=n || i<0 || j<0 || grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;
        count+=dfs(grid,i+1,j);
        count+=dfs(grid,i-1,j);
        count+=dfs(grid,i,j-1);
        count+=dfs(grid,i,j+1);

        return count;
    }
}
