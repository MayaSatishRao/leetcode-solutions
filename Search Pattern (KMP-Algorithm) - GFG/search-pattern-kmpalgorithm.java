//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void fillLPS(String pat, int[] lps){
        int len=0,i=1;
        while(i<pat.length()){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }else
                  len = lps[len-1];
            }
        }
        
    }
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int n = txt.length(), m=pat.length();
        ArrayList<Integer> res = new ArrayList<>();
        int[] lps = new int[m];
        fillLPS(pat,lps);
        
        int i=0,j=0;
        while(i<n){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }else{
                if(j==0)
                  i++;
                else
                  j=lps[j-1];
            }
            
            if(j==m){
                res.add(i-m+1);
                j=lps[j-1];
            }
        }
        
        return res;
    }
}