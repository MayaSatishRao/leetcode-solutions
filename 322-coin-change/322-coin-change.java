class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length,n=amount;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<n+1;i++)
            dp[0][i]=1000000;
        for(int i=0;i<m+1;i++)
            dp[i][0]=0;
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        
        if(dp[m][n]>=1000000)
            return -1;
        
        return dp[m][n];
        
    }
}