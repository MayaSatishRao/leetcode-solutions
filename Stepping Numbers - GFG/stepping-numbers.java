//{ Driver Code Starts
//Initial Template for Java


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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int explorePaths(int val, int n, int m){
        if(val>m)
        return 0;
    
        int ans=0;
        if(val>=n && val<=m)
        ans=1;
        
        int lastDigit = val%10;
        if(lastDigit!=0)
        ans+=explorePaths(val*10+(lastDigit-1),n,m);
        if(lastDigit!=9)
        ans+=explorePaths(val*10+(lastDigit+1),n,m);
        
        return ans;
    }
    int steppingNumbers(int n, int m){
        // code here
        int res=0;
        
        if(n==0)
        res=1;
        
        for(int i=1;i<10;i++){
            res+=explorePaths(i,n,m);
        }
        
        return res;
    }
}
