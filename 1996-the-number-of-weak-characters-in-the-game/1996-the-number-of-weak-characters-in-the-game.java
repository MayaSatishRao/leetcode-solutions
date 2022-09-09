class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });
        
        int currMax=0,count=0;
        for(int i=0;i<properties.length;i++){
            if(properties[i][1]<currMax)
                count++;
            else
                currMax=properties[i][1];
        }
        return count;
    }
}