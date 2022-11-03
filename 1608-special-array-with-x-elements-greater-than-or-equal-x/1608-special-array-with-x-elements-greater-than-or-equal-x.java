class Solution {
    
    public int binarySearch(int[] arr, int key){
        int low=0, high=arr.length-1;
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(arr[mid]<key)
                low=mid+1;
            else
                high=mid-1;
        }
        
        return low;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length-1];
        int res=-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
             int j = binarySearch(nums,mid);
              if(mid==nums.length-j)
                  res=mid;
              if(mid<=nums.length-j)
                  low=mid+1;
            else
                high=mid-1;
           /// System.out.println(mid+" "+(nums.length-j));
        }
        
        return res;
    }
}