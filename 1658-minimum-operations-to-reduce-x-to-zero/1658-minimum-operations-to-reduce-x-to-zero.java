class Solution {
    
    public int getMaxSubarray(int[] arr, int sum){
        
        int res=Integer.MIN_VALUE,prefix=0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        for(int i=0;i<arr.length;i++){
            prefix+=arr[i];
            
             if(prefix==sum){
                res=Math.max(res,i+1);
            }else if(hm.get(prefix-sum)!=null){
                int start=hm.get(prefix-sum);
                res=Math.max(res,i-start);
            }
            
            if(hm.get(prefix)==null)
                hm.put(prefix,i);
            
            
        }
        
        return res;
    }
    public int minOperations(int[] nums, int x) {
        int totalSum=0,n=nums.length;
        for(int i=0;i<n;i++)
            totalSum+=nums[i];
        
        if(totalSum==x)
            return n;
        
        int length = getMaxSubarray(nums,totalSum-x);
        
        return length==Integer.MIN_VALUE?-1:n-length;
    }
}