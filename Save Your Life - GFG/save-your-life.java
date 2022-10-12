//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        //code here
        int curr=0,res=Integer.MIN_VALUE;
        String currStr="",resStr="";
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            hm.put(x[i],b[i]);
        }
        
        for(int i=0;i<w.length();i++){
            int val = (hm.get(w.charAt(i))==null)?(int)w.charAt(i):hm.get(w.charAt(i));
            
            if(curr+val>=val){
                curr=curr+val;
                currStr = currStr +w.charAt(i);
            }else {
                curr=val;
                currStr=""+w.charAt(i);
            }
            
            if(res<=curr){
                res=curr;
                resStr= new String(currStr);
            }
            //System.out.println(curr);
        }
        
        return resStr;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends