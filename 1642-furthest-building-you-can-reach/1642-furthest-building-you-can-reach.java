class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int bricksUsed=0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<heights.length-1;i++){
            int diff = heights[i+1]-heights[i];
           
            if(diff>0){
                pq.add(diff);
                if(pq.size()>ladders)
                    bricksUsed+=pq.poll();
            }
            
            if(bricksUsed>bricks)
                return i;
        }
        
        return heights.length-1;
    }
}