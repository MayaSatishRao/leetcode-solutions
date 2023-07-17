//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        int[] freq = new int[26];
        Arrays.fill(freq,-1);
        
        StringBuilder str = new StringBuilder(A);
        
        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            if(freq[ch-'a']!=-1){
                freq[ch-'a'] = -2;
            }else{
                freq[ch-'a']=i;
            }
            
            int val=i,min=ch-'a';
            for(int j=0;j<26;j++)
              if(freq[j]>=0 && freq[j]<val){
                      min=j;
                      val=freq[j];
               }
            if(freq[min]>=0){
                char c = (char)(97+min);
                str.setCharAt(i,c);
            }else{
                str.setCharAt(i,'#');
            }
            
        }
        
        return str.toString();
    }
}