//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int a;
            a = Integer.parseInt(br.readLine());
            
            
            int b;
            b = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.solve(a, b);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int a, int b) {
        // code here
        int one=0, zero=0;
        for(int i=0;i<=31;i++){
            
            int c = a&1, d=b&1;
            if(c==0 && d==1)
             one=1;
            if(c==1 && d==0)
             zero=1;
            a>>=1;
            b>>=1;
        }
        
        return one+zero;
    }
}
        
