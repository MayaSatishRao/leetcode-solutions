//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int totalSum = 0, n=arr.length;
        for(int i=0;i<n;i++)
         totalSum+=arr[i];
         
         if(sum>totalSum)
           return false;
        
        boolean[][] dp = new boolean[n+1][totalSum+1];
        for(int i=1;i<totalSum+1;i++)
         dp[0][i]=false;
         
         for(int i=0;i<n+1;i++)
          dp[i][0]=true;
          
        for(int i=1;i<n+1;i++){
            for(int j=1;j<totalSum+1;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                
                if(arr[i-1]<=j)
                 take=dp[i-1][j-arr[i-1]];
                 
                 dp[i][j] = take| notTake;
            }
        }
        
        
        return dp[n][sum];
    }
}