class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])==null){
                ArrayList<Integer> ans = new ArrayList<Integer>();
                ans.add(i);
                hm.put(nums[i],ans);
            }else{
                hm.get(nums[i]).add(i);
            }
        }
        
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> arr = hm.get(target-nums[i]);
            for(int j=0;arr!=null && j<arr.size();j++){
            
                if(arr.get(j)!=i){
                   ans[0]=i;
                    ans[1]=arr.get(j);
                    return ans;
                }
            }
            
        }
        
        return ans;
    }
}