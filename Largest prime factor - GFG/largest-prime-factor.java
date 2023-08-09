//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean isPrime(int n){
        
        if(n==0 || n==1)
          return false;
        if(n==2 || n==3)
          return true;
        if(n%2==0 || n%3==0)
           return false;
           
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0)
              return false;
        }
        
        return true;
    }
    static long largestPrimeFactor(int N) {
        // code here
        int res=1;
        //boolean[] prime = new boolean[N+1];
        for(int i=1;i*i<=N;i++){
            if(N%i==0){
                if(isPrime(i))
                  res=Math.max(res,i);
                if(isPrime(N/i))
                  res=Math.max(res,N/i);
            }
        }
        
        
        
        return res;
    }
}