//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
        int i=0,res=0;
        while(i<n){
            int j=i;
            while(j<n && arr[j]!=0)
              j++;
            
            
            int count=0, startIndex=-1, endIndex=-1;
            for(int k=i;k<j;k++)
              if(arr[k]<0){
                  if(startIndex==-1){
                        startIndex=k;
                        endIndex=k;
                  }else
                  endIndex=k;
                  count++;
              }
            if(count%2==0)
              res=Math.max(res,j-i);
            else{
                int len = Math.max(j-startIndex-1,endIndex-i);
                res=Math.max(res,len);
            }
            
            i=j+1;
        }
        return res;
        
        
    }
   
}