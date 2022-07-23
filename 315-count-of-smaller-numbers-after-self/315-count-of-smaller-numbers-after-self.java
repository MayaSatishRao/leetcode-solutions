class Solution {
    
    private int[] count;
    public void merge(int[] arr, int[] index,int low, int mid, int high){
          int n1 = mid-low+1, n2=high-mid;
          int[] left = new int[n1];
          int[] right = new int[n2];
        
          for(int i=0;i<n1;i++){
              left[i]=index[low+i];
          }
          for(int i=0;i<n2;i++)
              right[i]=index[mid+1+i];
         
          int i=0,j=0,k=low,rightCount=0;
           while(i<n1 && j<n2){
               if(arr[left[i]]<=arr[right[j]]){
                   count[left[i]]+=rightCount;
                   index[k++]=left[i++];
               }else{
                   rightCount++;
                   index[k++]=right[j++];
               }
           }
        
        while(i<n1){
            count[left[i]]+=rightCount;
            index[k++]=left[i++];
        }
        
        while(j<n2)
            index[k++]=right[j++];
              
    }
    public void mergeSort(int[] arr, int[] index, int low, int high){
        if(low<high){
            int mid = low + (high-low)/2;
            mergeSort(arr,index,low,mid);
            mergeSort(arr,index,mid+1,high);
            merge(arr,index,low,mid,high);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        int[] indexArray = new int[nums.length];
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++)
            indexArray[i]=i;
        
        mergeSort(nums,indexArray,0,nums.length-1);
        
        for(int i=0;i<nums.length;i++)
            res.add(count[i]);
        
        return res;
    }
}