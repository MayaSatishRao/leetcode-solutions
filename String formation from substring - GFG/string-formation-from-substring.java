// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isRepeat(input);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    void constructLPS(String s, int[] lps){
        lps[0]=0;
        int len=0,i=1;
        while(i<s.length()){
            if(s.charAt(len)==s.charAt(i)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }else{
                    len = lps[len-1];
                }
            }
        }
    }
    int isRepeat(String s) {
        // code here
        int n= s.length();
        int[] lps = new int[n];
        constructLPS(s,lps);
      
        
       if(lps[n-1]>0 && n%(n-lps[n-1])==0)
       return 1;
        
        
        
        
        
        //System.out.println(res+" "+small);
        
        
        return 0;
    }
}