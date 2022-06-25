class Solution {
    public boolean checkPossibility(int[] nums) {
       boolean change=false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1] && !change){
                 // case1 compare left and right
                if(i>0 && nums[i-1]<=nums[i+1])
                    nums[i]=nums[i+1];
                else if(i<nums.length-2 && nums[i]<=nums[i+2])
                    nums[i+1]=nums[i];
                else if(i==0)
                    nums[i]=nums[i+1];
                else if(i==nums.length-2)
                     nums[i+1]=nums[i];
                else
                    return false;
                change=true;
            }
            else if(nums[i]>nums[i+1] && change)
                return false;
        }
        
        return true;
    }
}