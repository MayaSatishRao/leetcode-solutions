//{ Driver Code Starts
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
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length, m=grid[0].length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int[][] dist = new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
               dist[i][j] = Integer.MAX_VALUE;
               
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
              if(grid[i][j]==1){
                  q.add(new int[]{i,j});
                  visit[i][j]=true;
                  dist[i][j]=0;
              }
         
         
         
         while(!q.isEmpty()){
             int[] p =q.poll();
             
             for(int i=0;i<4;i++){
                 int x = p[0]+dir[i][0];
                 int y = p[1]+dir[i][1];
                 
                 if(x<0 || y<0 || x>=n || y>=m)
                    continue;
                 
                 if(!visit[x][y]){
                     dist[x][y] = dist[p[0]][p[1]]+1;
                     q.add(new int[]{x,y});
                     visit[x][y]=true;
                 }else{
                     if(dist[x][y]>dist[p[0]][p[1]]+1){
                         dist[x][y] = dist[p[0]][p[1]]+1;
                         q.add(new int[]{x,y});
                     }
                 }
             }
         }
        
        return dist;
        
    }
}