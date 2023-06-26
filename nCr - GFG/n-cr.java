//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        if(r>n)
          return 0;
          
        ArrayList<Integer> arr= new ArrayList<Integer>();
        arr.add(1);
        arr.add(1);
        arr.add(0);
        
        int p = (int)Math.pow(10,9)+7;
        int i=2;
        while(i<=n){
            int size = Math.min(i,r);
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=1;j<=size;j++){
                int a = (arr.get(j) + arr.get(j-1))%p;
                curr.add(a);
            }
            curr.add(0);
            arr = curr;
            i++;
        }
        
        return arr.get(r);
    }
}