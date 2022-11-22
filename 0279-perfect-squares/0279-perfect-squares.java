class Solution {
    public int numSquares(int n) {
         ArrayList<Integer> arr = new ArrayList<Integer>();
         for(int i=1;;i++){
             if((i*i)>n)
                 break;
             arr.add((i*i));
         }
        
        int[] count = new int[n+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0]=0;
        
        for(int i=1;i<n+1;i++){
            for(int j=0;j<arr.size();j++){
                if(i>=arr.get(j)){
                    int ans = 1+count[i-arr.get(j)];
                    count[i]=Math.min(count[i],ans);
                }
            }
        }
        
        return count[n];
    }
}