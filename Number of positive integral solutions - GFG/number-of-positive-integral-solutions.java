// { Driver Code Starts
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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.posIntSol(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long factorial(int n){
        long res=1;
        for(int i=1;i<=n;i++)
        res*=i;
        
        return res;
    }
    long posIntSol(String s)
    {
        //code here.
        int equalPosition=0,i=0,n=s.length();
        while(i<n && s.charAt(i)!='=')
        i++;
        
        equalPosition=i;
        String[] arr = s.substring(0,equalPosition).split("\\+");
        int r = arr.length;
        
        int N = Integer.parseInt(s.substring(equalPosition+1,n));
        N-=r;
        
        long p = 1,multiplier = (long)(N+r-1);
        i=0;
        while(i<r-1){
            p*=multiplier;
            multiplier--;
            i++;
        }
        
        return p/factorial(r-1);
    }
}