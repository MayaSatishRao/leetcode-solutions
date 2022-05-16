class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> p = new HashMap<Integer,Integer>();
        for(int i=0;i<score.length;i++)
            p.put(score[i],i);
        
        String[] res = new String[score.length];
        Arrays.sort(score);
        
        int rank=1;
        for(int i=score.length-1;i>=0;i--){
            int index = p.get(score[i]);
            if(rank==1){
                res[index]="Gold Medal";
            }else if(rank==2){
                res[index]="Silver Medal";
            }else if(rank ==3){
                res[index]="Bronze Medal";
            }else{
                res[index]=Integer.toString(rank);
            }
            rank++;
        }
        
        return res;
        
    }
}