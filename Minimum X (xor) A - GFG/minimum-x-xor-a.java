//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static int countBits(int n){
        int count=0;
        while(n>0){
            if(n%2==1)
             count++;
            n/=2;
        }
        return count;
    }
    public static int minVal(int a, int b) {
        // code here
        int c = countBits(b);
        int res=0;
        
        for(int i=31;i>=0 && c>0;i--){
            if((a & (1<<i))==(1<<i)){
                res|=(1<<i);
                c--;
            }
        }
        
        //System.out.println(res)
         for(int i=0;i<=31 && c>0;i++){
            if((res & (1<<i))==0){
                res|=(1<<i);
                c--;
            }
        }
        
        return res;
    }
}