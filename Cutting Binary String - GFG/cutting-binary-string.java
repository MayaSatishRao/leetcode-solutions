//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean isPower(long n){
        if(n==0)
          return false;
        
        while(n>1){
            if(n%5!=0)
             return false;
            n/=5;
        }
        
        if(n==1)
          return true;
        
        return false;
    }
    
    static int recSol(String s, int index){
        if(index==s.length())
          return 0;
        if(s.charAt(index)=='0')
           return -1;
        
        long res = 0;
        int n = s.length();
        int ans = -1;
        
        for(int i=index;i<n;i++){
            
            long digit= s.charAt(i)-'0';
            res = res*2+digit;
           /* if(index==0)
              System.out.println(res);*/
              
            if(isPower(res)){
            
                //System.out.println(res+" "+index);
                int a = recSol(s,i+1);
                if(a!=-1)
                  ans = 1+a;
            }
        }
        
        
        return ans;
        
    }
    static int cuts(String s)
    {
        // code here
        int ans = recSol(s,0);
        if(ans==0)
          return -1;
        return ans;
    }
}
