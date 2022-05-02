class Solution {
    public int[] sortArrayByParity(int[] arr) {
     /*   int i=0;
        int j=nums.length-1;
        int[] res = new int[nums.length];
        
        for(int k=0;k<nums.length;k++){
            if(nums[k]%2==0){
                res[i]=nums[k];
                i++;
            }else{
                res[j]=nums[k];
                j--;
            }
        }
        
        return res;*/
        
        int n = arr.length;
        int i=-1,j=n;
        
        while(true){
            do{
                i++;
            }while(i<n && arr[i]%2==0);
            do{
                j--;
            }while(j>=0 && arr[j]%2==1);
            
            if(i>=j)
                break;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        
        return arr;
    }
}