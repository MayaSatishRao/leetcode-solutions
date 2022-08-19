class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> sequenceEnd = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])==null)
                hm.put(nums[i],1);
            else
                hm.put(nums[i],hm.get(nums[i])+1);
        }
        
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])==0)
                continue;
            
            hm.put(nums[i],hm.get(nums[i])-1);
            
            if(sequenceEnd.get(nums[i]-1)!=null && sequenceEnd.get(nums[i]-1)>0){
                sequenceEnd.put(nums[i]-1,sequenceEnd.get(nums[i]-1)-1);
                if(sequenceEnd.get(nums[i])==null)
                sequenceEnd.put(nums[i],1);
                else
                sequenceEnd.put(nums[i],sequenceEnd.get(nums[i])+1);
            }else if((hm.get(nums[i]+1)!=null && hm.get(nums[i]+1)>0) && (hm.get(nums[i]+2)!=null && hm.get(nums[i]+2)>0)){
                
                hm.put(nums[i]+1,hm.get(nums[i]+1)-1);
                hm.put(nums[i]+2,hm.get(nums[i]+2)-1);

                if(sequenceEnd.get(nums[i]+2)==null)
                    sequenceEnd.put(nums[i]+2,1);
                else
                    sequenceEnd.put(nums[i]+2,sequenceEnd.get(nums[i]+2)+1);
            }else
                return false;
                
        }
        
        return true;

    }
}