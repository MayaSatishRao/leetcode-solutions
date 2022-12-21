//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        long res=0;
         
         long curr=0;
         HashMap<Long,Long> hm = new HashMap<>();
         hm.put((long)0,(long)1);
         
         for(int i=0;i<n;i++){
             curr+=arr[i];
             if(hm.get(curr)!=null)
              res+=hm.get(curr);
             
             hm.put(curr, hm.getOrDefault(curr,(long)0)+1);
         }
         
         return res;
    }
}