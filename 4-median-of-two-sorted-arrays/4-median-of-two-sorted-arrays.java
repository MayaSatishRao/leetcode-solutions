class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int[] arr = new int[n];
        int i=0;
        
        for(;i<nums1.length;i++)
            arr[i]=nums1[i];
        for(int j=0;j<nums2.length;j++)
            arr[i++]=nums2[j];
        
        for(i=0;i<n-1;i++){
            int flag=0;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0)
                break;
        }
        
        
        
        if(n%2!=0)
            return (double)arr[((n+1)/2)-1];
        else
            return (double)((float)(arr[(n/2)-1]+arr[(n/2)])/2);
    }
}