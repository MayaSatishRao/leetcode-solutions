// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0){
		   
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    
		    Solution obj = new Solution();
		    System.out.println(obj.countOnes(arr, n));
		    
		}
		
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function to count number of ones in the binary array
    // N: size of array
    // arr[]: input array
    public static int countOnes(int arr[], int N){
        
        // Your code here
        int ans=0,low=0,high=arr.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(arr[mid]==0){
                high=mid-1;
            }else{
                low=mid+1;
                ans=low;
            }
        }
        
        return ans;
        
    }
}

