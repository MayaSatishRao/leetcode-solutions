//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
        


    
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
          return true;
       
        
        return false;
    }
    
    public String rearrangeString(int[] high, int[] low){
        StringBuilder res= new StringBuilder();
        
        
        while(true){
            int i=0,j=0;
           for(;i<26;i++)
             if(high[i]>0)
                break;
           for(;j<26;j++)
              if(low[j]>0)
                 break;
        
           if(i==26 && j==26)
           break;
           
           if(i<26){
               res.append((char)(i+97));
               high[i]--;
           } 
           
           if(j<26){
               res.append((char)(j+97));
               low[j]--;
           }
           
           
           
           
        }
        
        return res.toString();
    }
    
    public String rearrange(String S, int N){
        int[] vowel= new int[26];
        int[] cons = new int[26];
        
        int v=0,c=0;
        for(int i=0;i<S.length();i++){
            if(isVowel(S.charAt(i))){
                v++;
                vowel[S.charAt(i)-'a']++;
            }
              
            else{
                c++;
                cons[S.charAt(i)-'a']++;
            }
              
        }
        
        if(Math.abs(v-c)>1)
         return "-1";
        
        if(v>c)
          return rearrangeString(vowel,cons);
        else if(v==c){
            int i=0,j=0;
            for(;i<26;i++)
              if(vowel[i]>0)
                 break;
            for(;j<26;j++)    
               if(cons[j]>0)
                 break;
             if(i>j)
               return rearrangeString(cons,vowel);
             else
               return rearrangeString(vowel,cons);
        }
        
        return rearrangeString(cons,vowel);
    
    }
}