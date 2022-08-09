class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int p = (int)Math.pow(10,9)+7;
        
        HashMap<Integer,Long> hm = new HashMap<Integer,Long>();
        for(int i=0;i<n;i++)
        hm.put(arr[i],(long)1);
        
        int res=n;
        for(int i=1;i<arr.length;i++){
            long count=0;
            for(int j=i-1;j>=0;j--){
                if(arr[i]%arr[j]==0 && hm.get(arr[i]/arr[j])!=null){
                    count=(count+hm.get(arr[j])*hm.get(arr[i]/arr[j]))%p;
                }
            }
            hm.put(arr[i],(hm.get(arr[i])+count));
            res=(res+(int)count)%p;
            
        }
        
        return res;
        
    }
}