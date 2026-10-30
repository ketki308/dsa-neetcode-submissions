class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    
        if(image[sr][sc]!=color){
        dfs(image,sr,sc,color);
        }
        return image;
    }
    private void dfs(int[][] grid,int i,int j,int color){
        int m=grid.length;
        int n=grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!=1){
            return;
        }

        grid[i][j]=color;
        
        dfs(grid,i+1,j,color);
        dfs(grid,i-1,j,color);
        dfs(grid,i,j+1,color);
        dfs(grid,i,j-1,color);
    }

}