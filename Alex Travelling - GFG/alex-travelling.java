//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    
    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        int[][] adjMat = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(i==j)
                  adjMat[i][j] = 0;
                else
                  adjMat[i][j]=-1;
            }
        
        for(int i=0;i<flights.length;i++){
            int r = flights[i][0]-1 , c=flights[i][1]-1 , v = flights[i][2];
            adjMat[r][c] = v;
        }
        
        int[] values = new int[n];
        boolean[] visit = new boolean[n];
        
        for(int i=0;i<n;i++)
            values[i]=1000;
        values[k-1]=0;
        
        for(int i=0;i<n;i++){
            int u=-1;
            for(int j=0;j<n;j++)
              if(!visit[j] && (u==-1 || values[j]<values[u]))
                u=j;
            
            visit[u]=true;
            for(int j=0;j<n;j++)
              if(!visit[j] && adjMat[u][j]!=-1 && values[u]+adjMat[u][j]<values[j])
                 values[j]=values[u]+adjMat[u][j];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
          if(values[i]==1000)
            return -1;
          else
            max = Math.max(max,values[i]);
        
       // System.out.println(Arrays.toString(values));
        return max;
            
    }
}
