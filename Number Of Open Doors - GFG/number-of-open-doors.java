//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.noOfOpenDoors(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    static int noOfOpenDoors(Long N) {
        // code here
      /*  int res=0;
        long i=1;
        
        while(i*i<=N){
            res++;
            i++;
        }
        return res;*/
        return (int)Math.sqrt(N);
    }
};