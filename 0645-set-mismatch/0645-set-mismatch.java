class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length,repeat=0,not=0;
        boolean[] present = new boolean[n];
        for(int i=0;i<n;i++){
            if(!present[nums[i]-1])
                present[nums[i]-1]=true;
            else if(present[nums[i]-1])
                repeat=nums[i];
        }
        
        for(int i=1;i<n+1;i++)
            if(!present[i-1])
                not=i;
        
        int[] res= new int[2];
        res[0]=repeat;
        res[1]=not;
        
        return res;
    }
}