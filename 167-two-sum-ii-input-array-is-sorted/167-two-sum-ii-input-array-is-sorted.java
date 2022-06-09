class Solution {
    public int[] twoSum(int[] arr, int target) {
        
        int j=arr.length-1;
        int i=0;
        int[] ans={0,0};
        while(i<j){
            if(arr[i]+arr[j]==target)
                break;
            if(arr[i]+arr[j]>target)
                j--;
            else
                i++;
        }
        ans[0]=i+1;
        ans[1]=j+1;
        return ans;
    }
}