class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
          HashMap<Integer,Integer> hm = new HashMap<>();
          hm.put(0,-1);
        
          int sum=0,res=0;
          for(int i=0;i<nums.length;i++){
              sum+=nums[i];
              int rem = sum%k;
              if(hm.get(rem)==null)
                  hm.put(rem,i);
              else
                  res=Math.max(res,i-hm.get(rem));
          }
        
        // System.out.println(res);
        
         return res>=2;
        
    }
}