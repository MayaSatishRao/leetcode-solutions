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
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
        ArrayList<String> res = new ArrayList<String>();
        for(int i=0;i<N;i++){
            String str= Dictionary[i];
            int k=0;
            for(int j=0;j<str.length() && k<Pattern.length();j++){
                char ch = str.charAt(j);
                if(ch>='A' && ch<='Z'){
                    if(ch==Pattern.charAt(k))
                      k++;
                    else
                      break;
                }
            }
            
            if(k==Pattern.length())
              res.add(str);
        }
        
        Collections.sort(res);
        if(res.size()==0)
          res.add("-1");
        return res;
        
    }
}