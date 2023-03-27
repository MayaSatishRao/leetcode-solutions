//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int recSol(int N, int K, int start, int[][][] dp){
        if(N==0 && K==0){
              return 1;
        }
        
        if(K==0 || N<=0)
          return -1;
        
        if(dp[N][K][start]==-1){
            int ans=0;
        for(int i=start;i<=N;i++){
            int a = recSol(N-i,K-1,i,dp);
             if(a>0)
              ans+=a;
        }
           dp[N][K][start]=ans;
        }
        
          
        //System.out.println(N+" "+K+" "+start+" "+ans);
        return dp[N][K][start];
        
    }
    public int countWaystoDivide(int N, int K) {
        // Code here
        int[][][] dp = new int[N+1][K+1][N+1];
        for(int i=0;i<=K;i++)
           for(int j=0;j<=N;j++){
               Arrays.fill(dp[j][i],-1);
           }
       
       return recSol(N,K,1,dp); 
      /*  for(int i=0;i<=N;i++)
            for(int j=0;j<=N;j++)
               dp[i][0][j]=-1;
       
       for(int i=0;i<=N;i++)
          dp[0][0][i]=1;
       
       for(int i=1;i<=N;i++){
           for(int j=1;j<=K;j++){
               
               int prefix=0;
               for(int l=N;l>=1;l--){
                   
                   if(i>=l && dp[i-l][j-1][l]>0){
                       dp[i][j][l]+=(dp[i-l][j-1][l]+prefix);
                       prefix+=dp[i-l][j-1][l]; 
                       //System.out.println(dp[i][j][l]);
                   }
                    
               }
               System.out.println(Arrays.toString(dp[i][j])+" "+i+" "+j);
           }
       }
       
       return dp[N][K][N];-*/
    }
}