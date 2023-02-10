//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        int[] alp = new int[26];
        for(int i=0;i<s.length();i++)
          alp[s.charAt(i)-'a']++;
        
        String str = "balon";
        int res = alp['b'-'a'];
        
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)=='l' || str.charAt(i)=='o')
              res = Math.min(res, alp[str.charAt(i)-'a']/2);
            else
              res =  Math.min(res, alp[str.charAt(i)-'a']);
        }
        
        return res;
    }
}