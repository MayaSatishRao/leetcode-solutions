//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    boolean isPossible(int[] arr, long min, int k){
        int p=0;
        long curr=0;
        
        for(int i=0;i<arr.length;i++){
            curr+=arr[i];
            if(curr>=min){
                p++;
                curr=0;
            }
        }

        
        
        //System.out.println(p+" "+min);
        return p>=k+1;
          
    }
	int maxSweetness(int [] arr, int N, int K) {
	    // Write your code here.
	    long sum=0,min=Integer.MAX_VALUE;
	    for(int i=0;i<N;i++){
	        sum+=arr[i];
	        min=Math.min(min,arr[i]);
	    }
	      
	    
	    long low=min, high=sum;
	    long res=0;
	    
	    while(low<=high){
	        long mid = low+(high-low)/2;
	        //System.out.println(low+" "+high+" "+mid);
	        if(isPossible(arr,mid,K)){
	            res=mid;
	            low=mid+1;
	        }else
	          high=mid-1;
	    }
	    
	    return (int)res;
	}
}