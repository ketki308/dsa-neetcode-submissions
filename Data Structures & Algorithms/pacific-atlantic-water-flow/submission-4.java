class Solution {
    private void dfs(int i,int j,int[][] heights,boolean[][] vis){
        int m=heights.length;
        int n=heights[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};

        q.offer(new int[]{i,j});
        vis[i][j]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !vis[nr][nc] && heights[nr][nc]>=heights[r][c]){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();

        int m=heights.length;
        int n=heights[0].length;

        boolean[][] pacificreachable=new boolean[m][n];
        boolean[][] atlanticreachable=new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,heights,pacificreachable);
            dfs(i,n-1,heights,atlanticreachable);
        }

        for(int j=0;j<n;j++){
            dfs(0,j,heights,pacificreachable);
            dfs(m-1,j,heights,atlanticreachable);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificreachable[i][j] && atlanticreachable[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
}
