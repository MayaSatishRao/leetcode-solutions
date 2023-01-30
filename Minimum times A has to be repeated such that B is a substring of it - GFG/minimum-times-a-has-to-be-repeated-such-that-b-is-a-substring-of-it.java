//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int res=Integer.MAX_VALUE;
        for(int k=0;k<A.length();k++){
            int j=0,counter=0,i=k;
            while(j<B.length()){
                if(A.charAt(i)!=B.charAt(j))
                  break;
                i++;
                j++;
                
                if(i==A.length() && j!=B.length())
                  counter++;
                i%=A.length();
            }
            
           
            if(j==B.length())
              res=Math.min(res,counter+1);
        }
        
        return res==Integer.MAX_VALUE?-1:res;
    }
};