class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int count=0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<heights.length-1;i++){
            int diff = heights[i+1]-heights[i];
           
            if(diff>0){
                if(pq.size()<ladders){
                    pq.add(diff);
                }else{
                    if(pq.size()>0 && pq.peek()<diff){
                         int br = pq.poll();
                         pq.add(diff);
                         if(bricks>=br)
                             bricks-=br;
                        else
                            return i;
                    }else{
                        if(bricks>=diff)
                           bricks-=diff;
                        else
                            return i;
                    }
                        
                }
                
            }
        }
        
        return heights.length-1;
    }
}