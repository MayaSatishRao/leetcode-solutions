class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length,res=0;
        for(int i=0;i<n-1;i++){
            int curr = nums[i+1]-nums[i],currLength=1;
            for(int j=i+1;j<n-1;j++){
                int diff = nums[j+1]-nums[j];
                if(curr<0 && diff>0){
                   currLength++;
                    curr=diff;
                }else if(curr>0 && diff<0){
                    currLength++;
                    curr=diff;
                }      
            }
            
            if(curr!=0)
            res=Math.max(currLength,res);
        }
        
        //System.out.println(res);
        
        return res+1;
    }
}