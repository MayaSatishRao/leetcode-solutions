//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
   /* static String getColor(String a, String b){
        if((a.equals("R") && b.equals("G")) || (a.equals("G") && b.equals("R")))
        return "B";
        
        if(a.equals("R") && b.equals("B") || (a.equals("B") && b.equals("R")))
        return "G";
        
        return "R";
    }*/
    
    static int minFind(int n, String a[]){
        // code here
       int r=0,g=0,b=0;
       for(int i=0;i<n;i++){
           if(a[i].equals("R"))
           r++;
           else if(a[i].equals("G"))
           g++;
           else 
           b++;
       }
       
      // System.out.println(r+" "+g+" "+b);
       if(g==n || b==n || r==n)
       return n;
       
       if((g%2==0 && b%2==0 && r%2==0) || (g%2==1 && b%2==1 && r%2==1))
       return  2;
       
       return 1;
    }
}