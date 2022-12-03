//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public static int countCows(int[] arr, int mid){
        int req=1, startPos=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[startPos]>=mid){
                req++;
                startPos=i;
            }
        }
        return req;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low=0,high=stalls[n-1]-stalls[0];
        int res=Integer.MIN_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(countCows(stalls,mid)>=k){
                res=mid;low=mid+1;
            }else
              high=mid-1;
              
              //System.out.println(mid+" "+countCows(stalls,mid));
        }
        
        return res;
    }
}