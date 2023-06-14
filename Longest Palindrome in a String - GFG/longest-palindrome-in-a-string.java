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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static String longestPalin(String S){
        // code here
        int n = S.length(),res=0;
        String ans="";
        for(int i=0;i<n;i++){
            // odd length palindrome
            int left = i-1, right=i+1;
            while(left>=0 && right<n){
                if(S.charAt(left)==S.charAt(right)){
                    left--;
                    right++;
                }else
                   break;
            }
            if(res<right-left-1){
                res = right-left-1;
                ans = S.substring(left+1,right);
            }
            
            //even length palindrome
            left=i;
            right=i+1;
            while(left>=0 && right<n){
                if(S.charAt(left)==S.charAt(right)){
                    left--;
                    right++;
                }else
                   break;
            }
            if(res<right-left-1){
                res = right-left-1;
                ans = S.substring(left+1,right);
            }
            
        }
        
        return ans;
    }
}