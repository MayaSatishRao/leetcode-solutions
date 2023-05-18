//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean dfs(int[][] matrix, int r, int c, boolean[][] visit){
        //System.out.println("start "+r+" "+c);
        visit[r][c]= true;
        int[][] diff = {{-1,0},{0,-1},{1,0},{0,1}};
        int n = visit.length, m=visit[0].length;
        
        boolean ans = true;
        if(r==0 || c==0 || r==n-1 || c==m-1)
           ans = false;
          
        
        
        for(int i=0;i<diff.length;i++){
            int row = r+diff[i][0], col=diff[i][1]+c;
            
            if(row>=0 && row<n && col>=0 && col<m && matrix[row][col]==1 && !visit[row][col]){
                boolean a = dfs(matrix,row,col,visit);
                //System.out.println(row+" "+col+" "+a);
                 ans = ans && a;
            }
               
        }
        
        return ans;
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        int res=0;
        boolean[][] visit= new boolean[N][M];
        //System.out.println(dfs(matrix,1,3,visit));
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(matrix[i][j]==1 && !visit[i][j] && dfs(matrix,i,j,visit)){
                    //System.out.println(i+" "+j);
                    res++;
                }
                  
            }
        }
        
        return res;
    }
}