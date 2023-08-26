//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int[] alp = new int[26];
        Arrays.fill(alp,-1);
        
        int i=0,j=0,res=-1;
        while(j<s.length()){
            alp[s.charAt(j)-'a']=j;
            int c=0;
            for(int K=0;K<26;K++){
                if(alp[K]!=-1)
                 c++;
            }
            
            if(c==k){
                
               res=Math.max(res,j-i+1); 
            }else if(c>k){
                int temp = Integer.MAX_VALUE,ind=-1;
                
                for(int K=0;K<26;K++)
                  if(alp[K]!=-1 && alp[K]<temp){
                      temp=alp[K];
                      ind=K;
                  }
                      
                //System.out.println(i+" "+j+" "+temp+" "+res);
                i = temp+1;
                alp[ind]=-1;
                res=Math.max(res,j-i+1);
            }
            j++;
        }
        return res;
    }
}