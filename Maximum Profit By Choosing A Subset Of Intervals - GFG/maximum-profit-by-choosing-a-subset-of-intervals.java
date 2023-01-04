//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    
    
    public static int binSearch(int low, int value, int[][] arr){
        int n = arr.length;
        int high=n-1;
        int res=n;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(arr[mid][0]>=value){
                res=mid;
                high=mid-1;
            }else
              low=mid+1;
              
        }
        
        return res;
        
    }
    
    public static int solve(int index, int[][] arr, int[] dp){
        if(index==arr.length)
          return 0;
        if(dp[index]!=-1)
          return dp[index];
          
        // not consider the element
        int ans = solve(index+1,arr,dp);
        int newIndex = binSearch(index+1,arr[index][1],arr);
        
        ans = Math.max(ans, arr[index][2]+solve(newIndex,arr,dp));
        
        dp[index]= ans;
        return dp[index];
        
    }
    public static int maximum_profit(int n, int[][] intervals) {
        // code here
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1])
                  return a[2]-b[2];
                
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        return solve(0,intervals,dp);
    }
}
