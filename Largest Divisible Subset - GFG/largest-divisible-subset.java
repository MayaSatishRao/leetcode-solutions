//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                        (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int N, int[] arr) {
        // Code here
        Arrays.sort(arr);
        int[] dp = new int[N];
        int[] parent = new int[N];
     
        dp[0]=1;     
        parent[0]=0;
        int ind=0;
        for(int i=1;i<N;i++){
            parent[i]=i;
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]%arr[j]==0){
                    if(dp[i]<1+dp[j]){
                        dp[i]=1+dp[j];
                        parent[i]=j;
                    }
                }
                
            }
            if(dp[i]>dp[ind])
              ind=i;
        }
        
        List<Integer> res = new ArrayList<>();
        while(ind!=parent[ind]){
            //System.out.println(arr[ind]);
            res.add(arr[ind]);
            ind=parent[ind];
        }
        res.add(arr[ind]);
        return res;
    }
}
