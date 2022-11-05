//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int arr[] = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxGroupSize(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxGroupSize(int[] arr, int n, int k) {
        // code herei
        
        int[] rem = new int[k];
        for(int i=0;i<n;i++)
          rem[arr[i]%k]++;
          
        int res=0;
        if(rem[0]>0)
        res++;
        
        for(int i=1;i<(k+1)/2;i++){
            res+=Math.max(rem[i],rem[k-i]);
        }
        
        if(k%2==0 && rem[k/2]>0)
        res+=1;
        
        return res;
    }
};