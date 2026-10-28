class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;

        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int minutes=0;
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0],c=curr[1];
            boolean rottenthisminute=false;

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                    fresh--;
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc]=2;
                    rottenthisminute=true;
                }
            }
            if(rottenthisminute) minutes++;
        }

        return (fresh==0)?minutes:-1;
    }
}
