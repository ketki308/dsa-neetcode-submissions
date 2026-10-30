class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor=image[sr][sc];
        if(image[sr][sc]!=color){
        dfs(image,sr,sc,color,originalcolor);
        }
        return image;
    }
    private void dfs(int[][] grid,int i,int j,int color,int originalcolor){
        int m=grid.length;
        int n=grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!=originalcolor){
            return;
        }

        grid[i][j]=color;
        
        dfs(grid,i+1,j,color,originalcolor);
        dfs(grid,i-1,j,color,originalcolor);
        dfs(grid,i,j+1,color,originalcolor);
        dfs(grid,i,j-1,color,originalcolor);
    }

}