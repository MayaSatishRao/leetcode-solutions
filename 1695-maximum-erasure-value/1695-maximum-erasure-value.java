class Solution {
    
    
    public int maximumUniqueSubarray(int[] nums) {
        int res=0,sum=0;
        int start=0,end=0;
        HashSet<Integer> subarray = new HashSet<Integer>();
        while(end<nums.length){
            if(!subarray.contains(nums[end])){
                subarray.add(nums[end]);
                sum+=nums[end];
                res=Math.max(res,sum);
                end++;
            }else{
                
                subarray.remove(nums[start]);
                sum-=nums[start];
                start++;
            }
        }
        
       
        return res;
    }
}