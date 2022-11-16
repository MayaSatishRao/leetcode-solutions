//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int[] minMax(int[] alp){
        int[] res=new int[2];
        res[0]=Integer.MAX_VALUE;
        res[1]=Integer.MIN_VALUE;
        
        for(int i=0;i<26;i++){
            if(alp[i]<res[0] && alp[i]>0)
              res[0]=alp[i];
            if(alp[i]>res[1] && alp[i]>0)
              res[1] = alp[i];
        }
        
        return res;
    }
    public static int beautySum(String s) {
        // code here
        int res=0;
        for(int i=0;i<s.length();i++){
            int[] alp = new int[26];
            alp[s.charAt(i)-'a']++;
            
            for(int j=i+1;j<s.length();j++){
                alp[s.charAt(j)-'a']++;
                int[] ans = minMax(alp);
                res+=ans[1]-ans[0];
            }
        }
        
        return res;
    }
}
        
