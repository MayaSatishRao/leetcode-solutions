// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        HashMap<Long,Integer> hm1 = new HashMap<Long,Integer>();
        HashMap<Long,Integer> hm2 = new HashMap<Long,Integer>();
        
        for(int i=0;i<N;i++){
            if(hm1.get(A[i])==null){
                hm1.put(A[i],1);
            }else{
                int a = hm1.get(A[i]);
                hm1.remove(A[i]);
                hm1.put(A[i],a+1);
            }
        }
        
        for(int i=0;i<N;i++){
            if(hm2.get(B[i])==null){
                hm2.put(B[i],1);
            }else{
                int a = hm2.get(B[i]);
                hm2.remove(B[i]);
                hm2.put(B[i],a+1);
            }
        }
        
        for(int i=0;i<N;i++){
            if(hm2.get(A[i])==null)
            return false;
            if(hm1.get(A[i])!=hm2.get(A[i]))
            return false;
        }
        
        return true;
    }
}