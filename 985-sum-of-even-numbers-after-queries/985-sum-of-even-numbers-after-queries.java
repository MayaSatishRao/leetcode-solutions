

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int n = queries.length;
        int[] res = new int[n];
       
        
        int sum=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]%2==0){
                sum+=nums[i];
            }
        
        for(int i=0;i<n;i++){
            int index = queries[i][1];
            int val=queries[i][0];
            if(nums[index]%2!=0 && (nums[index]+val)%2==0)
                sum+=(nums[index]+val);
            else if(nums[index]%2==0 && (nums[index]+val)%2==0)
                sum+=val;
            else if(nums[index]%2==0 && (nums[index]+val)%2!=0)
                sum-=nums[index];
            //System.out.println(nums[index]+" "+nums[index]%2);
            nums[index]+=val;
            res[i]=sum;
        }
                
        return res;
    }
}