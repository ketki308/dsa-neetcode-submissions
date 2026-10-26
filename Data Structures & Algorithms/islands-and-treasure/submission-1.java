class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid.length;
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dir={{1,0},{0,1},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0],c=cur[1];

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==Integer.MAX_VALUE){
                    grid[nr][nc]=grid[r][c]+1;

                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
