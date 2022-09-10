class Solution {
    public int minSwaps(int[] nums) {
        int count=0;
        
        for(int i=0;i<nums.length;i++)
            if(nums[i]==1)
                count++;
        
        int curr=0;
        for(int i=0;i<count;i++)
            if(nums[i]==1)
                curr++;
        if(curr==count)
            return 0;
        
        int res=Integer.MAX_VALUE;
        
        for(int i=count;i<nums.length+count;i++){
            if(nums[i%nums.length]==1)
                curr++;
            if(nums[(i-count)%nums.length]==1)
                curr--;
            res=Math.min(res,count-curr);
        }
        
        return res;
    }
}