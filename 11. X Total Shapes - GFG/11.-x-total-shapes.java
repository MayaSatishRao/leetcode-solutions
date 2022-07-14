// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the number of 'X' total shapes.
    public void dfs(char[][] grid, boolean[][] visit, int r, int c){
        visit[r][c]=true;
        
        if(c>0 && grid[r][c-1]=='X' && !visit[r][c-1])
        dfs(grid,visit,r,c-1);
        if(c<grid[0].length-1 && grid[r][c+1]=='X' && !visit[r][c+1])
        dfs(grid,visit,r,c+1);
        if(r>0 && grid[r-1][c]=='X' && !visit[r-1][c])
        dfs(grid,visit,r-1,c);
        if(r<grid.length-1 && grid[r+1][c]=='X' && !visit[r+1][c])
        dfs(grid,visit,r+1,c);
        
    }
    public int xShape(char[][] grid)
    {
        // code here
        //System.out.println(grid.length+" "+grid[0].length);
        int n = grid.length,m=grid[0].length;
        boolean[][] visit = new boolean[n][m];
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X' && !visit[i][j]){
                    dfs(grid,visit,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
}