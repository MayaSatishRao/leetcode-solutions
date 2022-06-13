class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m= spells.length, n=potions.length;
        int[] res = new int[m];
        Arrays.sort(potions);
        
        
        for(int i=0;i<m;i++){
            int j=0;
            int low=0,high=n-1;
            
            while(low<=high){
                int mid = low+(high-low)/2;
                long product = (long)potions[mid]*(long)spells[i];
                if(product>=success){
                    j=mid;
                    high=mid-1;
                }else
                    low=mid+1;
            }
            
            long p1 = (long)spells[i], p2=(long)potions[j];
            long p3= p1*p2;
            if(p3>=success)
            res[i]=n-j;
            else
                res[i]=0;
        }
        
        return res;
    }
}