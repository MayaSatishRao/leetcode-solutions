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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            int[] ans = ob.changeBits(N);
            System.out.println(ans[0]+ " "+ ans[1]);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] changeBits(int N) {
        // code here
        double n = Math.log(N)/Math.log(2);
        int a = (int)Math.ceil(n);
        
        if(a==Math.floor(n))
        a++;
        
        int[] res = new int[2];
        res[1]=(int)(Math.pow(2,a))-1;
        res[0]=res[1]-N;
        
        return res;
        
    }
};