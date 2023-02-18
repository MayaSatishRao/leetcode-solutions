//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int i=0,j=0,res=-1,count=0;
        while(i<n && j<n){
            if(arr.charAt(j)=='O')
             count++;
            if(count<=m)
             res=Math.max(res,j-i+1);
            else{
                while(i<n && arr.charAt(i)=='A')
                i++;
                i++;
                count--;
            }
            j++;
           // System.out.println(res+" "+i+" "+j);
        }
        
        return res;
        
    }
}


//{ Driver Code Starts.

// } Driver Code Ends