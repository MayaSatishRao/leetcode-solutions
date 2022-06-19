class Solution {
    public int numOfSubarrays(int[] arr) {
        
        
        int res=0, N= (int)Math.pow(10,9)+7,n=arr.length;
       /* for(int i=0;i<arr.length;i++){
            int sum=arr[i];
            if(sum%2==1)
                res=(res+1)%N;
            for(int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                if(sum%2==1)
                    res=(res+1)%N;
            }
        }*/
        int odd=0,even=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum%2==0)
                even++;
            else
                odd++;
            
            if(sum%2==1)
                res=(res+1)%N;
            
            if(sum%2==0)
                res=(res+odd)%N;
            else
                res=(res+even)%N;
            
        }
        
        return res;
    }
}