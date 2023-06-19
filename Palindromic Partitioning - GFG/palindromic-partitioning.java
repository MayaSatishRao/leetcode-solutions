//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean isPalindrome(String str, int i, int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
              return false;
            i++;
            j--;
        }
        return true;
    }
    static int recSol(String str, int start){
        if(start==str.length())
          return 0;
        
        int ans=Integer.MAX_VALUE; 
        for(int i=start;i<str.length();i++){
            if(isPalindrome(str,start,i)){
                int curr = recSol(str,i+1);
                ans = Math.min(ans,1+curr);
            }
        }
        
        return ans;
    }
    static int palindromicPartition(String str)
    {
        // code here
        
        int n = str.length();
        int[] dp = new int[n];
        dp[n-1] = 1;
        
        for(int i=n-2;i>=0;i--){
            dp[i] = 1+dp[i+1];
            for(int j=i;j<n;j++){
                if(isPalindrome(str,i,j)){
                    int add = j==n-1?0:dp[j+1];
                    dp[i] = Math.min(add+1,dp[i]);
                }
                  
            }
        }
        
        //System.out.println(Arrays.toString(dp));
        return dp[0]-1;
        
      
        
    }
}