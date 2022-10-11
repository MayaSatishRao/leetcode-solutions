class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] =Math.max(nums[i],right[i+1]);
        }
        
       int[] left = new int[n];
        left[0]=nums[0];
        for(int i=1;i<n;i++){
            left[i]=Math.min(left[i-1],nums[i]);
        }
        
        for(int i=0;i<n;i++){
            if(left[i]<nums[i] && right[i]>nums[i])
                return true;
        }
        
        return false;
    }
}