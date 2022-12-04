class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n=nums.length;
        long sum=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];     
        }
        
         long currPrefix=0;
        
        long ans= Long.MAX_VALUE;
        int index=-1;
        for(int i=0;i<nums.length;i++){
            currPrefix+=nums[i];
            long right = sum-currPrefix;
            long left = currPrefix/(i+1);
            if((n-i-1)!=0)
            right/=(n-i-1);
            
            if(ans>Math.abs(left-right))
                index=i;
            ans = Math.min(ans,Math.abs(left-right));
        
        }
        
        return index;
    }
}