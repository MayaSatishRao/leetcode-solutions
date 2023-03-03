//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long B = Long.parseLong(input_line[1]);

            Solution ob = new Solution();
            List<Long> ans = new ArrayList<Long>();
            ans = ob.minimumSquares(L, B);
            System.out.print(ans.get(0)+" ");
            System.out.println(ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean isPossible(long l, long b, long k){
        if(l%k==0 && b%k==0)
           return true;
        return false;
    }
    static List<Long> minimumSquares(long L, long B)
    {
        // code here
        long i = 1, high=Math.min(L,B), ans=0;
        while(i*i<=high){
            if(isPossible(L,B,i))
              ans=Math.max(ans,i);
            if(high%i==0 && isPossible(L,B,high/i))
              ans=Math.max(ans,high/i);
              
            i++;
        }
        
        long num = (L*B)/(ans*ans);
        List<Long> res  =  new ArrayList<>();
        res.add(num);
        res.add(ans);
        return res;
    }
}