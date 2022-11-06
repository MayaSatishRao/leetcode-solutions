//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        int[] denominations = {1,2,5,10,20,50,100,200,500,2000};
        int[][] dp = new int[11][N+1];
        for(int i=0;i<N+1;i++)
          dp[0][i]=Integer.MAX_VALUE;
        for(int i=0;i<11;i++)
          dp[i][0]=0;
        
        for(int i=1;i<11;i++){
            for(int j=1;j<N+1;j++){
                if(j<denominations[i-1])
                  dp[i][j]=dp[i-1][j];
                else
                   dp[i][j]= Math.min(dp[i-1][j], 1+dp[i][j-denominations[i-1]]);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        int j=N, i=10;
        while(j>=0 && i>0){
            if(dp[i][j]!=dp[i-1][j]){
                res.add(denominations[i-1]);
                j=j-denominations[i-1];
            }else
              i--;
        }
       // System.out.println((dp[10][N])) ;
        
        
        return res ;
    }
}