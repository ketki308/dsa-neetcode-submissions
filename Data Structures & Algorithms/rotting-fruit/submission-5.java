class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int minute=0;
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean rottenthisminute=false;

            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];

                for(int[] d:dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr<m && nc<n && nr>=0 && nc>=0 && grid[nr][nc]==1){
                        fresh--;
                        q.offer(new int[]{nr,nc});
                        rottenthisminute=true;
                        grid[nr][nc]=2;
                    }
                }
            }
            if(rottenthisminute) minute++;
        }
        return (fresh==0)?minute:-1;
    }
}
