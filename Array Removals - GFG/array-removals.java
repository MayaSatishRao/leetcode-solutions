//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int binarySearch(int[] arr, int key){
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==key)
            return mid;
            if(arr[mid]<key)
            low=mid+1;
            else
            high=mid-1;
        }
        return low-1;
    }
    int removals(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int res=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int j = binarySearch(arr,arr[i]+k);
            //System.out.println(res);
            int len = j-i+1;
            res=Math.min(res,n-len);
        }
        
        
        return res;
    }
}