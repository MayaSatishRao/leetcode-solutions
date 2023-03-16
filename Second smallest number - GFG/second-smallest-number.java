//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        if(D*9<=S)
          return "-1";
          
        String res = "";
        
        for(int i=1;i<=9;i++){
            if(S-i<=(D-1)*9){
                res+=Integer.toString(i);
                S-=i;
                D--;
                break;
            }
        }
        
        while(D>0){
            if((D-1)*9>=S){
                res+="0";
            }else{
                int i=1;
                for(;i<=9;i++)
                   if(S-i<=(D-1)*9)
                      break;
                //System.out.println(i);
                res+=Integer.toString(i);
                S-=i;
            }
            D--;
            //System.out.println(res);
        }
        
        
        for(int i=res.length()-1;i>0;i--){
            int d = res.charAt(i)-48;
            int next = res.charAt(i-1)-48;
            
            if(d>0 && next<9){
                res = res.substring(0,i-1)+Integer.toString(next+1)+Integer.toString(d-1)+res.substring(i+1);
                return res;
            }
        }
        
        return "-1";
        
    }
}