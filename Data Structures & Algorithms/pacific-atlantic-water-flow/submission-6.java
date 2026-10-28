class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int i=0;i<m;i++){
            bfs(i,0,pacific,heights);
            bfs(i,n-1,atlantic,heights);
        }

        for(int j=0;j<n;j++){
            bfs(0,j,pacific,heights);
            bfs(m-1,j,atlantic,heights);
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
    private void bfs(int i,int j,boolean[][] visit,int[][] heights){
        int m=heights.length;
        int n=heights[0].length;
        Queue<int[]> q=new LinkedList<>();

        q.offer(new int[]{i,j});
        visit[i][j]=true;

        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0],c=curr[1];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !visit[nr][nc] && heights[nr][nc]>=heights[r][c]){
                    q.offer(new int[]{nr,nc});
                    visit[nr][nc]=true;
                }
            }
        }
    }
}
