// { Driver Code Starts
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
            String str[] = read.readLine().split(" ");
            String S= str[0];
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            Solution ob = new Solution();
            System.out.println(ob.stringPartition(S,a,b));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String stringPartition(String S, int a, int b){
        // code here
        int n=S.length();
        for(int i=1;i<n;i++){
            int c = Integer.parseInt(S.substring(0,i));
            //System.out.println(c);
            if(c%a==0){
                int d = Integer.parseInt(S.substring(i,n));
                if(d%b==0){
                    return S.substring(0,i)+" "+S.substring(i,n);
                }
            }
        }
        
        return "-1";
    }
}