class Solution {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int top=0;
        int bottom=len-1;

        while(top<bottom){
            for(int col=0;col<len;col++){
                int temp=matrix[top][col];
                matrix[top][col]=matrix[bottom][col];
                matrix[bottom][col]=temp;
            }
            top++;
            bottom--;
        }
        for(int row=0;row<len;row++){
            for(int col=row+1;col<len;col++){
                int temp=matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;
            }
        }
    }
}
