class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0)
            return 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<nums.length;i++)
            ts.add(nums[i]);
        
        int curr = ts.first(),count=1,res=1;
        ts.remove(curr);
        
        while(!ts.isEmpty()){
            int a = ts.first();
            if(a-1==curr){
                count++;
                curr++;
            }else{
                curr=a;
                res=Math.max(res,count);
                count=1;
            }
            ts.remove(a);
           
        }
        
        res=Math.max(res,count);
        return res;
    }
}