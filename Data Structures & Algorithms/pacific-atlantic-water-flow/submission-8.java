class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        List<List<Integer>> res=new ArrayList<>();

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int i=0;i<m;i++){
            bfs(i,0,heights,pacific);
            bfs(i,n-1,heights,atlantic);
        }

        for(int j=0;j<n;j++){
            bfs(0,j,heights,pacific);
            bfs(m-1,j,heights,atlantic);
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
    private void bfs(int i,int j,int[][] heights,boolean[][] visited){
        int m=heights.length;
        int n=heights[0].length;

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j]=true;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && heights[nr][nc]>heights[r][c]){
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }
}
