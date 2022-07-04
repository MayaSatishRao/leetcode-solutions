class Solution {
    
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] coins = new int[n];
        
        Arrays.fill(coins,1);
        
        for(int i=0;i<n-1;i++){
            if(ratings[i]<ratings[i+1])
               coins[i+1]=coins[i]+1;
        }
        for(int i=n-1;i>0;i--){
            if(ratings[i]<ratings[i-1]){
                if(coins[i]>=coins[i-1])
                    coins[i-1]=coins[i]+1;
            }
        }
        
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=coins[i];
        
        return sum;
    }
}