//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		//Write your code here
		if(n==1)
		  return arr;
		  
		int i=0,index=0;
		int[] res = new int[n];
		
		while(i<n-1){
		    int j=i;
		    while(j+1<n && (arr[j]+arr[j+1])%2==0)
		      j++;
		    
		    int[] temp = new int[j-i+1];
		    for(int k=0;k<temp.length;k++)
		      temp[k] = arr[k+i];
		    Arrays.sort(temp);
		    
		    //System.out.println(i+" "+temp.length);
		    for(int k=0;k<temp.length;k++){
		        res[index++] = temp[temp.length-k-1];
		        //System.out.println(i+" "+temp.length);
		    }
		       
		  
		    
		    i=j+1;
		    
		}
		
		if(index==n-1)
		  res[index] = arr[index];
		  
		return res;
	}
}