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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    boolean dfs(int[][] grid,boolean[][] visit,int cr, int cc, int dr, int dc){
        visit[cr][cc]=true;
        if(cr==dr && cc==dc)
        return true;
        
        boolean ans = false;
        // top
        if(cr>=1 && grid[cr-1][cc]!=0  && !visit[cr-1][cc])
        ans = ans ||  dfs(grid,visit,cr-1,cc,dr,dc);
        // bottom
        if(cr<grid.length-1 && grid[cr+1][cc]!=0 && !visit[cr+1][cc])
        ans = ans || dfs(grid,visit,cr+1,cc,dr,dc);
        // left
        if(cc>=1 && grid[cr][cc-1]!=0 && !visit[cr][cc-1])
        ans =ans || dfs(grid,visit,cr,cc-1,dr,dc);
        // right
        if(cc<grid[0].length-1 && grid[cr][cc+1]!=0 && !visit[cr][cc+1])
        ans = ans || dfs(grid,visit,cr,cc+1,dr,dc);
        
        return ans;
    }
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int dr=0,dc=0,sr=0,sc=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    sr=i;
                    sc=j;
                }else if(grid[i][j]==2){
                    dr=i;
                    dc=j;
                }
            }
        }
        
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        return dfs(grid,visit,sr,sc,dr,dc);
    }
}