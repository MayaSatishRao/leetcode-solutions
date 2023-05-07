//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        // code here
        int i=1;
        char ch = str.charAt(0);
        
        String curr= ""+str.charAt(0);
        String prev = ""+str.charAt(0);
        String res = curr+prev;
        
        while(i<str.length()){
            if(str.charAt(i)<=ch){
                curr += str.charAt(i);
                prev = str.charAt(i)+prev;
                String n = new String(curr+prev);
                if(res.compareTo(n)>0)
                  res = new String(n);
                
                i++;
            }else
              break;
                
        }
        
        
        return res;
    }
}
        
