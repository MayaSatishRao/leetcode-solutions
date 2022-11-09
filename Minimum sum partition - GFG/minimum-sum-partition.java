//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
   /*  public int minDiff(int[] arr, int i, int curr, int total){
         if(i==arr.length){
             int set2 = total-curr;
             //System.out.println(Math.abs(curr-set2));
             return Math.abs(curr-set2);
         }
         
         return Math.min(minDiff(arr,i+1,curr+arr[i],total), minDiff(arr,i+1,curr,total));
     }*/
     

     
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	   
	    int sum=0,res=arr[0];
	    for(int i=0;i<n;i++)
	    sum+=arr[i];
	    
	     boolean[][] dp = new boolean[n][sum+1];
	     for(int i=0;i<n;i++)
	       dp[i][0]=true;
	     
	       
	       dp[0][arr[0]]=true;
	       int p = sum-arr[0];
	       res=Math.abs(p-arr[0]);
	       for(int i=1;i<n;i++){
	           for(int j=1;j<sum+1;j++){
	               boolean notTake = dp[i-1][j];
	               boolean take = (arr[i]<=j)?dp[i-1][j-arr[i]]:false;
	               
	               dp[i][j]=take || notTake;
	               
	               if(dp[i][j]){
	                   int set2 = sum-j;
	                   res=Math.min(res,Math.abs(j-set2));
	               }
	           }
	       }
	    return res;
	} 
}
