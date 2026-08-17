class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String>set=new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char temp=board[i][j];

                if(temp=='.'){ continue ;}

                String row="row"+i+temp;
                String col="col"+j+temp;
                String box="box"+(i/3)+(j/3)+temp;

                if(set.contains(row) || set.contains(col) || set.contains(box)){
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        return true;
    }
}
