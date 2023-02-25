//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int i=0, j=0;
        while(i<T.length() && j<S.length()){
            int k=i;
            while(i<T.length() && T.charAt(i)>='0' && T.charAt(i)<='9')
               i++;
            if(k!=i){
                int freq = Integer.parseInt(T.substring(k,i));
                j+=freq;
            }
            
            if(i<T.length() && j<S.length()){
                if(T.charAt(i) != S.charAt(j)){
                   // System.out.println(T.charAt(i)+" "+ S.charAt(j));
                    return 0;
                }
                   
                i++;
                j++;
            }
            
            
        }
        
        //System.out.println(i+" "+j+" "+T.length()+" "+S.length());
        if(i==T.length() && j==S.length())
          return 1;
        
        return 0;
    }
}