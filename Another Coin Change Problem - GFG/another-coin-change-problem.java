//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static boolean recSol(int i, int k, int target, int curr, int[] coins){
        
        
        if(k==0){
            if(target==curr)
              return true;
            return false;
        }
        
        if(i==coins.length)
          return false;
        
        int no=0;
        while(curr<=target){
            if(no!=0)
            curr+=coins[i];
            boolean res = recSol(i+1,k-no,target, curr,coins);
            if(res)
              return true;
            no++;
        }
        
        return false;
        
    }
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        boolean[][] dp = new boolean[K+1][target+1];
        for(int i=0;i<K+1;i++)
           dp[i][0] = false;
        for(int i=0;i<target+1;i++)
          dp[0][i] = false;
        
        dp[0][0] = true;
        
        for(int i=1;i<=K;i++){
            for(int j=1;j<=target;j++){
                
                // looping for all elements
                for(int k=0;k<N;k++){
                    if(coins[k]<=j)
                    dp[i][j] |= dp[i-1][j-coins[k]];
                   
                }
            }
        }
        
       /* for(int i=0;i<=K;i++)
        System.out.println(Arrays.toString(dp[i]));*/
        return dp[K][target];
    }
}
