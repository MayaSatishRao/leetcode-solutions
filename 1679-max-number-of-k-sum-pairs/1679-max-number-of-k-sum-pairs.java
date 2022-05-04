class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>();
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            if(arr.get(nums[i])==null){
                arr.put(nums[i],1);
            }else{
                int a = arr.get(nums[i]);
                arr.remove(nums[i]);
                arr.put(nums[i],a+1);
            }
        }
        
        int count=0;
        for(int i=0;i<nums.length;i++){
        
            int freq1= arr.get(nums[i]);
            int freq2 = (arr.get(k-nums[i])==null)?0:arr.get(k-nums[i]);
            
            if(nums[i]!=k-nums[i] && freq1>0 && freq2>0)
            count+=1;
            if(nums[i]==k-nums[i] && freq1>=2)
            count+=1;
            
            //System.out.println(freq1+" "+freq2);
            if(nums[i]!=k-nums[i]){
                 arr.remove(nums[i]);
            arr.put(nums[i],freq1-1);
            
            if(freq2!=0){
                arr.remove(k-nums[i]);
                arr.put(k-nums[i],freq2-1);
            }
            }else{
                if(freq2!=0){
                arr.remove(k-nums[i]);
                arr.put(k-nums[i],freq2-2);
            }
            }
           
                                                             
        }
            
        return count;
        
        
    }
}