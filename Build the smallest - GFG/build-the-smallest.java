//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int N) {
        // code here
        ArrayDeque<Character> stk = new ArrayDeque<>();
        int size = str.length()-N;
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(N>0){
                while(!stk.isEmpty() && N>0 && stk.peek()>ch){
                    stk.pop();
                    N--;
                }
            }
            if(stk.size()<size)
            stk.push(ch);
            //System.out.println(stk);
        }
        
        StringBuilder s = new StringBuilder();
        while(!stk.isEmpty())
        s.append(stk.pop());
        
        
        
        
        String res =  s.reverse().toString();
       // System.out.println(res);
       
        int i=0;
        for(;i<res.length()-1;i++)
           if(res.charAt(i)!='0')
            break;
        return res.substring(i);
    }
}