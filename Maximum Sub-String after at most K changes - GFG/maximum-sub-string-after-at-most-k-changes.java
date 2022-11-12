//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        // code here
        
        int res=Math.max(k,1);
        
       /*for(int i=0;i<s.length()-k;i++){
           
           int[] freq = new int[26];
           freq[s.charAt(i)-'A']++;
           
           for(int j=i+1;j<s.length();j++){
               freq[s.charAt(j)-'A']++;
               int len = j-i+1,max=0;
               
               for(int l=0;l<26;l++)
                 max=Math.max(freq[l],max);
            
               if(Math.abs(max-len)<=k)
                res=Math.max(res,len);
           }
       }*/
       
       int start=0, end=0, maxFreq=0;
       int[] freq = new int[26];
       
       while(start<=end && end<s.length()){
           char ch = s.charAt(end);
           freq[ch-'A']++;
           maxFreq = Math.max(maxFreq,freq[ch-'A']);
           
           int len = end-start+1;
           while(Math.abs(maxFreq-len)>k){
               freq[s.charAt(start)-'A']--;
               maxFreq = Math.max(maxFreq,freq[ch-'A']);
               start++;
               len=end-start+1;
           }
           
               res=Math.max(res,len);
               end++;
       }
       
       return res;
    }
}