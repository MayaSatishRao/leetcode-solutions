class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int res=0,boxes=0;
        
        for(int i=0;i<boxTypes.length;i++){
            if(boxes+boxTypes[i][0]<=truckSize){
                res+=(boxTypes[i][0]*boxTypes[i][1]);
                boxes+=boxTypes[i][0];
            }else{
                int remain = truckSize-boxes;
                res+=remain*boxTypes[i][1];
                break;
            }
            //System.out.println(res+" "+boxes);
        }
       
        return res;
    }
}