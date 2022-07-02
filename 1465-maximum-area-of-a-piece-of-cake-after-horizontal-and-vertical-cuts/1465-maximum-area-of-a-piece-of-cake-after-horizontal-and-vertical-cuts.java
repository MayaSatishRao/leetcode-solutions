class Solution {
    
    public int getMaxDiff(int[] arr, int N){
        int res = arr[0];
        for(int i=0;i<arr.length-1;i++)
            res=Math.max(res,arr[i+1]-arr[i]);
        
        res=Math.max(res,N-arr[arr.length-1]);
        return res;
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int N = (int)Math.pow(10,9)+7;
        
        int maxLength = getMaxDiff(horizontalCuts,h);
        int maxWidth = getMaxDiff(verticalCuts,w);
        
        
        long p = ((long)maxLength*(long)maxWidth)%N;
        return (int)p;
    }
}