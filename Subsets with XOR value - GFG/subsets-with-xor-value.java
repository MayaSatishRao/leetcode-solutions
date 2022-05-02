// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

 // } Driver Code Ends
//User function Template for Java

class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        // code here
        if(N==0)
        return K==0?1:0;
        
        return subsetXOR(arr,N-1,K) + subsetXOR(arr,N-1,K^arr[N-1]);
    }
}

// { Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        }
    }
}  // } Driver Code Ends