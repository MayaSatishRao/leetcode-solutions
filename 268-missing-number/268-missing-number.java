class Solution {
    public int missingNumber(int[] nums) {
        int actual=0;
        int sum=0;
        for(int i=0;i<nums.length+1;i++)
            actual=actual^i;
        for(int j=0;j<nums.length;j++)
            sum=sum^nums[j];
        return actual^sum;
    }
}