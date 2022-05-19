

class KthLargest {

    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        K=k;
        for(int i=0;i<k && i<nums.length;i++)
            pq.add(nums[i]);
        
        for(int i=k;i<nums.length;i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
    }
    
    public int add(int val) {
        if(pq.size()<K){
            pq.add(val);
        }else{
       if(val>pq.peek()){
           pq.poll();
           pq.add(val);
       }
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */