class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
       /* boolean[] present = new boolean[n];
        for(int i=0;i<n;i++){
            if(!present[nums[i]-1])
                present[nums[i]-1]=true;
            else if(present[nums[i]-1])
                repeat=nums[i];
        }
        
        for(int i=1;i<n+1;i++)
            if(!present[i-1])
                not=i;
        
        
        res[0]=repeat;
        res[1]=not;
        */
        int[] res= new int[2];
        
        for(int i=0;i<n;i++){
            if(nums[Math.abs(nums[i])-1]<0){
                res[0]=Math.abs(nums[i]);
            }else
            nums[Math.abs(nums[i])-1]*=-1;
        }
        
        for(int i=0;i<n;i++)
            if(nums[i]>0)
                 res[1]=i+1;
        
        return res;
    }
}