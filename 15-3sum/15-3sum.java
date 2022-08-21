class Solution {
   
   
public List<List<Integer>> threeSum(int[] nums) {
        
        // First sort the array, then start from first element
        // and look for 2 elements from left and right ends that will make the result set
        // nums = [-1,0,1,2,-1,-4]
        
        Arrays.sort(nums);
        
        // nums = [-4,-1,-1,0,1,2]
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int len = nums.length;
        if(len < 3) return res;
        int left = 1;
        int right = len - 1;
        int diff = 0;
        
        for(int i = 0; i < len-2; ++i) {
            
            // To avoid duplicates, skip if current element is same as previous
            if(i > 0 &&(nums[i] == nums[i - 1])) continue; 
            left = i + 1;
            right = len - 1;
            diff = 0 - nums[i];
            int lval = Integer.MIN_VALUE, rval = Integer.MAX_VALUE;// corner case     
            
            // start from the smallest and largest elements in right side of the current element
            while(left < right) {
                //To avoid duplicate triplets, store left and right values in variables
                // and before making triplets, just check if they already exist  
                if((nums[left] + nums[right]) == diff && nums[left] != lval && nums[right] != rval) {
                    temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    lval = nums[left];
                    rval = nums[right];
                    left++;
                    right--;
                    res.add(temp);
                }
                // if sum is less than what we want, we want a bigger number
                else if((nums[left] + nums[right]) < diff) 
                    left++;
                else
                    right--;
            }
        }
       return res; 
    }
}