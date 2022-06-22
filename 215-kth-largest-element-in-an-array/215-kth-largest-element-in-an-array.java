class Solution {
    
    public void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int lomutoPartition(int[] arr,int low, int high){
        int pivot = arr[high];
        int j=low;
        
        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
               swap(arr,i,j);
                j++;
            }
        }
        
        
           swap(arr,high,j);
            return j;
        
        
        
    }
    public int findKthLargest(int[] arr, int k) {
        int pos = arr.length-k;
        int low = 0, high=arr.length-1;
        
        while(true){
            int p = lomutoPartition(arr,low,high);
            if(p==pos)
                return arr[p];
            if(p>pos)
                high=p-1;
            else
                low=p+1;
            //System.out.println(p);
        }
    }
}