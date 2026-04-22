class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int column=board[0].length;

        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                if(dfs(board,word,r,c,0)){
                    return true;

                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int r,int c, int ind){
        if(ind==word.length()) return true;

        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(ind)){
            return false;
        }

        char temp=board[r][c];
        board[r][c]='#';

        boolean found=
              dfs(board,word,r+1,c,ind+1) ||
              dfs(board,word,r-1,c,ind+1) ||
              dfs(board,word,r,c+1,ind+1) ||
              dfs(board,word,r,c-1,ind+1);

            board[r][c]=temp;
        return found;
    }
}
