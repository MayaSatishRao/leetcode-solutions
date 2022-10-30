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
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        // Code here
        long[] arr = new long[N+1];
        arr[1]=1;
        
        long sum=1;
        for(int i=2;i<=6 && i<N+1;i++){
            arr[i]=sum*2;
            sum+=arr[i];
        }
        
        long prevSum=arr[1];
        for(int i=7;i<N+1;i++){
            sum-=arr[i-6];
            arr[i] = sum*2;
            sum+=arr[i];
           // System.out.println(Arrays.toString(arr));
        }
        
        return sum;
    }
}