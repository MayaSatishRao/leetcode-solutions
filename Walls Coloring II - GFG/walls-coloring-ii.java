//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int n = costs.length, k = costs[0].length;
		int[][] dp = new int[n][k];
		
		int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
		for(int i=0;i<k;i++){
		    dp[0][i] = costs[0][i];
		    if(costs[0][i]<min1){
		        min2=min1;
		        min1 = costs[0][i];
		    }
		    else if(costs[0][i]<min2 && costs[0][i]>=min1)
		      min2=costs[0][i];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=1;i<n;i++){
		    int curr1=Integer.MAX_VALUE, curr2 = Integer.MAX_VALUE;
		    for(int j=0;j<k;j++){
		        int diff=0;
		        if(dp[i-1][j] == min1)
		          diff = min2;
		        else
		          diff = min1;
		      
		        dp[i][j]=costs[i][j]+diff;
		    }
		    
		    for(int j=0;j<k;j++){
		    if(dp[i][j]<curr1){
		        curr2=curr1;
		        curr1 = dp[i][j];
		    }
		    else if(dp[i][j]<curr2 && dp[i][j]>=curr1)
		      curr2=dp[i][j];
		   }
		   
		   min1=curr1;
		   min2 = curr2;
		   
		}
		
		for(int i=0;i<k;i++)
		  ans = Math.min(ans,dp[n-1][i]);
		
		return ans<0?-1:ans;
	}
}