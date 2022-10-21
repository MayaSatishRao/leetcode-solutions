class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        int n = nums.length;
        
        for(int i=0;i<=k && i<n;i++){
            if(ts.contains(nums[i]))
                return true;
            ts.add(nums[i]);
        }
        
        for(int i=k+1;i<n;i++){
            ts.remove(nums[i-k-1]);
            if(ts.contains(nums[i]))
                return true;
            ts.add(nums[i]);
        }
        
        return false;
    }
}