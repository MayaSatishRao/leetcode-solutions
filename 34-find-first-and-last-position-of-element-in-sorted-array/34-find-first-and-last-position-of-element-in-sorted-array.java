class Solution {
   
    public static int firstIndex(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(arr[mid]==target){
            if(mid==0 || arr[mid-1]!=arr[mid])
                return mid;
                else
                    high=mid-1;
            }
            
            if(arr[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        
        return -1;
    }
    
    public int lastIndex(int[] arr,int target){
         int low=0;
        int high=arr.length-1;
        
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(arr[mid]==target){
                if(mid==arr.length-1 || arr[mid+1]!=arr[mid])
                    return mid;
                else
                    low=mid+1;
            }
             
            if(arr[mid]<target)
                low=mid+1;
            if(arr[mid]>target)
                high=mid-1;
        }
        
        return -1;
            
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int n=nums.length;
        int[] ans=new int[2];
           int[] arr={-1,-1};
        
        if(nums.length==0 || target<nums[0] || target>nums[n-1]){
            return arr;
        }
        
        int x=firstIndex(nums,target);
        if(x<0)
            return arr;
        
        ans[0]=x;
        ans[1]=lastIndex(nums,target);
        
        return ans;
    }
}