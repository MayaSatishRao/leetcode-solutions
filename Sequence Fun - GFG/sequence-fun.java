//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int NthTerm(int n)
    {
        // code here
        long ans=2;
        int p = (int)Math.pow(10,9)+7;
        for(int i=2;i<=n;i++){
            ans = (ans*i+1)%p;
            if(ans<0){
                ans=p-Math.abs(ans);
            }
            //System.out.println(ans);
        }
        return (int)ans;
    }
}