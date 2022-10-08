class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int res=0,diff=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int start = i+1, end=n-1;
            
            while(start<end){
                int s = nums[i]+nums[start]+nums[end];
                if(Math.abs(target-s)<diff){
                    diff = Math.abs(target-s);
                    res=s;
                }
                if(s<=target)
                start++;
                else
                end--;
            }
            //System.out.println(diff);
        }
        
        return res;
    }
}