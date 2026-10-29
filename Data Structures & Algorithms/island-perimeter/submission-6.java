class Solution {
    public int islandPerimeter(int[][] grid) {
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
        int perimeter=0;

        if(i>=m || j>=n || i<0 || j<0 || grid[i][j]==0){
            return 1;
        }

        if(grid[i][j]==2){
            return 0;
        }

        grid[i][j]=2;

        perimeter+=dfs(grid,i+1,j);
        perimeter+=dfs(grid,i-1,j);
        perimeter+=dfs(grid,i,j+1);
        perimeter+=dfs(grid,i,j-1);

        return perimeter;
        
    }
}