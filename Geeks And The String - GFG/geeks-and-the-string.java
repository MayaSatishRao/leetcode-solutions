//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        
      /*  while(s.length()>0){
            boolean change = false;
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    s = new String(s.substring(0,i)+s.substring(i+2));
                    change=true;
                    break;
                }
            }
            
            if(!change)
              break;
        }
        
        return (s.length()==0)?"-1":s;*/
        
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(!stk.isEmpty() && s.charAt(i)==stk.peek())
              stk.pop();
            else
              stk.push(s.charAt(i));
        }
        
        String res="";
        while(!stk.isEmpty()){
            res=stk.pop()+res;
        }
        return (res.length()==0)?"-1":res;
    }
}
        
