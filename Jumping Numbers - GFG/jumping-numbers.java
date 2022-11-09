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
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void adjacentNumbers(long x, String curr, long[] diff, long[] res){
        long y = Long.parseLong(curr);
        
           
       // System.out.println(curr);
        
        if(y>x){
            return ;
        }
        
        if(diff[0]>Math.abs(y-x)){
            res[0]=y;
            diff[0]=Math.abs(y-x);
        }else if(diff[0]==Math.abs(y-x))
           res[0]=Math.min(res[0],y);
        
        int lastDigit = (int)y%10;
        if(lastDigit!=0){
            adjacentNumbers(x,curr+(char)(lastDigit+48-1),diff,res);
        }
        if(lastDigit!=9){
            curr += (char)(lastDigit+1+48);
            adjacentNumbers(x,curr,diff,res);
        }
        
    }
    static long jumpingNums(long X) {
        // code here
        long[] ans = new long[1];
        long[] diff = new long[1];
        diff[0]=Long.MAX_VALUE;
        ans[0]=Long.MAX_VALUE;
        
        for(long i=1;i<10;i++)
          adjacentNumbers(X,Long.toString(i),diff,ans);
        
        return ans[0];
    }
};