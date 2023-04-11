//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    }
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    
            Solution ob = new Solution();
            int ans = ob.solve(a, b, c);
            
            out.println(ans);
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int recSol(int a, int b, int c, int[][][] dp){
        
        if(a+b+c<3){
            dp[a][b][c]=a+b+c;
            return dp[a][b][c];
        }
        
        if(dp[a][b][c]==-1){
            int ans=-1;
            int[][] diff = {{1,1,1},{2,0,1},{2,1,0},{0,2,1},{1,2,0},{0,1,2},{1,0,2}};
        
        for(int i=0;i<diff.length;i++){
            int a1 = a-diff[i][0];
            int b1 = b-diff[i][1];
            int c1 = c-diff[i][2];
            
            int ans1 = -1;
            if(a1>=0 && b1>=0 && c1>=0)
              ans1 = recSol(a1,b1,c1,dp);
            
            if(ans1!=-1){
                 ans = Math.max(ans,ans1+3);
            }
             
        }
        
        dp[a][b][c] = ans;
        }
        
        //System.out.println(a+" "+b+" "+c+" "+dp[a][b][c]);
        return dp[a][b][c];
        
    }
    int solve(int a, int b, int c) {
        // code here
        
        if(a>=b && a>=c){
            int max = (b+c+1)*2;
            if(a<=max)
              return a+b+c;
        }
        if(b>=a && b>=c){
            int max = (a+c+1)*2;
            if(b<=max)
             return a+b+c;
        }
        if(c>=a && c>=b){
            int max = (a+b+1)*2;
            if(c<=max)
             return a+b+c;
        }
        
        return -1;
       /* int ans=0;
        char prev='*';
        
        while(true){
            
           boolean found = false;
           if(a>0 && prev!='a'){
               int freq = (a>=2)?2:a;
               found=true;
               ans+=freq;
               a-=freq;
               prev='a';
           }
           if(b>0 && prev!='b'){
               int freq = (b>=2)?2:b;
               found=true;
               b-=freq;
               ans+=freq;
               prev='b';
           }
           if(c>0 && prev!='c'){
               int freq = (c>=2)?2:c;
               found=true;
               c-=freq;
               ans+=freq;
               prev='c';
           }
           
           if(!found)
             break;
        }
        
        if(a==0 && b==0 && c==0)
        return ans;
        
        return -1;*/
    }
};