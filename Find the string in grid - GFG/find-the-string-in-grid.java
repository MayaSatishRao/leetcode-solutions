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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        ArrayList<int[]> arr = new ArrayList<>();
        int m=grid.length, n=grid[0].length;
        int[][] diff = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<diff.length;k++){
                    int ind=0,row=i,col=j;
                    while(ind<word.length() && row>=0 && row<m && col>=0 && col<n){
                        if(grid[row][col]!=word.charAt(ind))
                          break;
                        row+=diff[k][0];
                        col+=diff[k][1];
                        ind++;
                    }
                    if(ind==word.length()){
                        arr.add(new int[]{i,j});
                        break;
                    }
                      
                }
            }
        }
        
        int[][] res = new int[arr.size()][2];
        for(int i=0;i<arr.size();i++)
          res[i]=arr.get(i);
        return res;
    }
}