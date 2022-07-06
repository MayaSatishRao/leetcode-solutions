// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends

class Pair{
    int row;
    int col;
    
    Pair(int r, int c){
        row=r;
        col=c;
    }
}
class Solution {
    // Function to find the number of islands.
    void bfs(char[][] grid, boolean[][] visit, int r, int c){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(r,c));
        visit[r][c]=true;
        while(!q.isEmpty()){
            int r1 =q.peek().row, c1=q.peek().col;
            q.poll();
            
            // upper row
            if(r1>=1){
                if(c1>=1 && grid[r1-1][c1-1]=='1' && visit[r1-1][c1-1]==false){
                    q.add(new Pair(r1-1,c1-1));
                    visit[r1-1][c1-1]=true;
                }
                if(grid[r1-1][c1]=='1' && visit[r1-1][c1]==false){
                    q.add(new Pair(r1-1,c1));
                    visit[r1-1][c1]=true;
                }
                if(c1<visit[0].length-1 && grid[r1-1][c1+1]=='1' && visit[r1-1][c1+1]==false){
                    q.add(new Pair(r1-1,c1+1));
                    visit[r1-1][c1+1]=true;
                }
            }
            
            // same row
            if(c1>=1 && grid[r1][c1-1]=='1' && visit[r1][c1-1]==false){
                    q.add(new Pair(r1,c1-1));
                    visit[r1][c1-1]=true;
            }
            if(c1<visit[0].length-1 && grid[r1][c1+1]=='1' && visit[r1][c1+1]==false){
                    q.add(new Pair(r1,c1+1));
                    visit[r1][c1+1]=true;
            }
            
            // bottom row
            if(r1<grid.length-1){
                if(c1>=1 && grid[r1+1][c1-1]=='1' && visit[r1+1][c1-1]==false){
                    q.add(new Pair(r1+1,c1-1));
                    visit[r1+1][c1-1]=true;
                }
                if(grid[r1+1][c1]=='1' && visit[r1+1][c1]==false){
                    q.add(new Pair(r1+1,c1));
                    visit[r1+1][c1]=true;
                }
                if(c1<visit[0].length-1 && grid[r1+1][c1+1]=='1' && visit[r1+1][c1+1]==false){
                    q.add(new Pair(r1+1,c1+1));
                    visit[r1+1][c1+1]=true;
                }
            }
            
         }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length,m=grid[0].length,count=0;
        boolean[][] visit = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visit[i][j]==false){
                    //System.out.println(i+" "+j);
                    bfs(grid,visit,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
}