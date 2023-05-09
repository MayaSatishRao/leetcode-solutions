//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            long N = Long.parseLong(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.countStrings(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int[][] matrixMultiply(int[][] a, int[][] b){
          int prime = (int)Math.pow(10,9)+7;
          int p = a.length, q = a[0].length;
          int r = b.length, s = b[0].length;
          
          int[][] res = new int[p][s];
          
          for(int i=0;i<p;i++){
              for(int j=0;j<s;j++){
                  for(int k=0;k<q;k++){
                      
                      long product = ((long)a[i][k]*(long)b[k][j])%prime;
                      long ans = ((long)res[i][j]+product)%prime;
                      res[i][j] = (int)ans;
                  }
              }
          }
          
          return res;
    }
    
    
    public int[][] matrixExponentiate(int[][] arr, long n){
        if(n==0){
            int sz = arr.length;
            int[][] res = new int[sz][sz];
            for(int i=0;i<sz;i++)
              res[i][i]=1;
            return res;
        }
        
        if(n==1)
         return arr;
        
        int[][] ans = matrixExponentiate(arr,n/2);
        ans = matrixMultiply(ans,ans);
        
        if(n%2==1){
            ans = matrixMultiply(ans,arr);
        }
        
        return ans;
    }
    public int countStrings(long N) {
        // Code here
        
        if(N==1)
          return 2;
        if(N==2)
          return 3;
        
        int[][] arr = {{1,1},{1,0}};
        arr = matrixExponentiate(arr,N-2);
        
        int[][] base = {{3},{2}};
        int[][] res = matrixMultiply(arr,base);
        return res[0][0];
        // matrix exponentiation
        // fibonacci {{1,1},{1,0}}
        
    }
}