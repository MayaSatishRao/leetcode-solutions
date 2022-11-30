class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];
        for(int i=0;i<arr.length;i++)
            freq[arr[i]+1000]++;
        boolean[] occ = new boolean[arr.length+1];
        
        for(int i=0;i<2001;i++)
            if(freq[i]>0){
                if(occ[freq[i]])
                    return false;
                occ[freq[i]]=true;
            }
        
        return true;
    }
}