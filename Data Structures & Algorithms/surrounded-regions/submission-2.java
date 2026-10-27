class Solution {
    private void dfs(char[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='O'){
            return;
        }

        grid[i][j]='S';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][n-1]=='O') dfs(board,i,n-1);
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O') dfs(board,0,i);
            if(board[m-1][i]=='O') dfs(board,m-1,i);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }
    }
}
