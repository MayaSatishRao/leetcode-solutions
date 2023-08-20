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
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    
    int first(int[] arr, int key){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==key){
                if(mid!=0 && arr[mid-1]==arr[mid])
                  high=mid-1;
                else
                  return mid;
            }else if(arr[mid]>key){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    
    int last(int[] arr, int key){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==key){
                if(mid!=arr.length-1 && arr[mid+1]==arr[mid])
                  low=mid+1;
                else
                 return mid;
            }else if(arr[mid]>key){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    
    int count(int[] arr, int n, int x) {
        // code here
        int i = first(arr,x);
        if(i==-1)
          return 0;
        int j=last(arr,x);
        return j-i+1;
    }
}