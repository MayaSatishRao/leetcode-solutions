class Solution {
    
    public int count(String s){
        int res=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='0')
                 res++;
        return res;
    }
   /* public int recursive(String[] strs, int index, int m, int n){
        if((m<=0 && n<=0) || index==strs.length)
            return 0;
        int m1 = count(strs[index],'0');
        int n1 = strs[index].length()-m1;
        
        int select = 0;
        if(m1<=m && n1<=n)
            select=1;
    
         
        return Math.max(select+recursive(strs,index+1,m-m1,n-n1),recursive(strs,index+1,m,n));
    }*/
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        int N = strs.length;
        for(int i=0;i<strs.length+1;i++)
            dp[i][0][0]=0;
        
        for(int i=0;i<m+1;i++)
            for(int j=0;j<n+1;j++)
                dp[0][i][j]=0;
        
        int[] zeroes = new int[N];
        for(int i=0;i<N;i++)
            zeroes[i]=count(strs[i]);
                
        for(int i=1;i<strs.length+1;i++){
            int ones = strs[i-1].length()-zeroes[i-1];
            for(int j=0;j<m+1;j++){
                for(int k=0;k<n+1;k++){
                    if(j==0 && k==0)
                        continue;
                    if(zeroes[i-1]<=j && ones<=k)
                        dp[i][j][k]=Math.max(dp[i-1][j][k], 1+dp[i-1][j-zeroes[i-1]][k-ones]);
                    else
                        dp[i][j][k]=dp[i-1][j][k];
                }
            }
        }
        
        return dp[N][m][n];
        
    }
}