class Solution {
    private int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
    private void bfs(int i,int j,boolean[][] visit,int[][] height){
        Queue<int[]> q=new LinkedList<>();
        int m=height.length;
        int n=height[0].length;
        q.offer(new int[]{i,j});
        visit[i][j]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0],c=curr[1];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !visit[nr][nc] && height[nr][nc]>=height[r][c]){
                    visit[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int r=0;r<m;r++){
            bfs(r,0,pacific,heights);
            bfs(r,n-1,atlantic,heights);
        }
        
        for(int c=0;c<n;c++){
            bfs(0,c,pacific,heights);
            bfs(m-1,c,atlantic,heights);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
}
