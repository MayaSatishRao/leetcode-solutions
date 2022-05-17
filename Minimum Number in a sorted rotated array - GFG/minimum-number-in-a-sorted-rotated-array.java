// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        int l = 0, h = arr.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(mid==0 || arr[mid-1]>arr[mid])
            return arr[mid];
            if(mid<arr.length-1 && arr[mid+1]<arr[mid])
            return arr[mid+1];
            
            if(arr[mid]<arr[h])
            h=mid-1;
            else
            l=mid+1;
        }
        return -1;
    }
}