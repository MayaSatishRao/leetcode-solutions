class Solution {
    
    int res = 0;
    public void dfs(int[][] grid, boolean[][] visit, int r, int c){
        visit[r][c]=true;
        res++;
        if(r>0 && !visit[r-1][c] && grid[r-1][c]==1)
            dfs(grid,visit,r-1,c);
        if(r<grid.length-1 && !visit[r+1][c] && grid[r+1][c]==1)
            dfs(grid,visit,r+1,c);
        if(c>0 && !visit[r][c-1] && grid[r][c-1]==1)
            dfs(grid,visit,r,c-1);
        if(c<grid[0].length-1 && !visit[r][c+1] && grid[r][c+1]==1)
            dfs(grid,visit,r,c+1);
        
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length , n=grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int ans=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && grid[i][j]==1){
                    dfs(grid,visit,i,j);
                    ans = Math.max(ans,res);
                    res=0;
                }
            }
        }
        
        return ans;
    }
}