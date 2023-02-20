//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    public static int func(int n, int loc, int[][] dp){
        
        int p = (int)Math.pow(10,9)+7;
        if(dp[n][loc]==0){
             if(n==0 && loc==0){
                 dp[n][loc] =  1;
                 return 1;
             }
              
             if(n==0 && loc!=0){
                 dp[n][loc] = 0;
                 return 0;
             }
               
             
             if(loc==0){
                 dp[n][loc]= (dp[n][loc]+func(n-1,1,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,2,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,3,dp))%p;
             }else if(loc==1){
                 dp[n][loc]= (dp[n][loc]+func(n-1,0,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,2,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,3,dp))%p;
             }else if(n==2){
                 dp[n][loc]= (dp[n][loc]+func(n-1,1,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,0,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,3,dp))%p;
             }else{
                 dp[n][loc]= (dp[n][loc]+func(n-1,1,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,2,dp))%p;
                 dp[n][loc]= (dp[n][loc]+func(n-1,0,dp))%p;
             }
             
        }
       
        return dp[n][loc];
        
    }
	public static int countPaths(int N){
		//code here
	/*	int[][] graph = new int[4][3];
		for(int i=0;i<4;i++){
		    int k=0;
		    for(int j=0;j<4;j++)
		      if(i!=j)
		        graph[i][k++]=j;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		
		int j=0,count=0;
		while(!q.isEmpty()){
		    int a=q.size();
		    if(j>N)
		     break;
		    for(int k=0;k<a;k++){
		        int p = q.poll();
		        if(p==0 && j==N)
		          count++;
		        for(int i=0;i<3;i++)
		           q.add(graph[p][i]);
		    }
		    
		    j++;
		}
		
		return count;*/
		int[][] dp = new int[N+1][4];
		 int p = (int)Math.pow(10,9)+7;
		for(int i=1;i<4;i++)
		  dp[0][i]=0;
		dp[0][0]=1;
		
		for(int i=1;i<N+1;i++){
		    for(int j=0;j<4;j++){
		        
		        dp[i][j] = (dp[i][j] + dp[i-1][(j+1)%4])%p;
		        dp[i][j] = (dp[i][j] + dp[i-1][(j+2)%4])%p;
		        dp[i][j] = (dp[i][j] + dp[i-1][(j+3)%4])%p;
		    }
		}
		
		
		return dp[N][0];
		   
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends