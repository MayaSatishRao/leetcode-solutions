class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
     /*   int[] temp = new int[n]; 
        for(int i=0;i<n;i++)
            temp[i]=nums[i];
        Arrays.sort(temp);
        for(int i=0;i<n;i++){
             
            if(temp[i]==nums[i])
                temp[i]=0;
            else if(temp[i]!=nums[i])
                temp[i]=1;
             
        } 
        int start=-1,end=-1;
        for(int i=0;i<n;i++){
            if(temp[i]==1){
                start=i;
                break;
            }
        }
        
        for(int i=n-1;i>=0;i--){
            if(temp[i]==1){
                end=i;
                break;
            }
        }
        
        if(start==-1 && end==-1)
            return 0;
        return end-start+1;
        */
        
        int max=nums[0], start=-1;
        for(int i=1;i<n;i++){
            if(nums[i]<max)
                start=i;
            else
                max=nums[i];
                
        }
        
        int min=nums[n-1],end=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]>min)
                end=i;
            else
                min=nums[i];
        }
        
        return start-end+1;
    }
}