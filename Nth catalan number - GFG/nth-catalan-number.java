//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public static int p = (int)Math.pow(10,9)+7;
    public static int ncr(int n, int r){
        int[][] dp = new int[n+1][r+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(r,i);j++){
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%p;
            }
        }
        
        /*for(int i=0;i<=n;i++){
            for(int j=0;j<=r;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        return dp[n][r];
    }
    public static int findCatalan(int n) {
        // code here
        int[][] dp = new int[2*n+1][n+2];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=2*n;i++){
            for(int j=1;j<=Math.min(n+1,i);j++){
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%p;
            }
        }
        
        int a = dp[2*n][n];
        int b = dp[2*n][n+1];
        
        return (int)((a-b+p)%p);
    }
}
        
