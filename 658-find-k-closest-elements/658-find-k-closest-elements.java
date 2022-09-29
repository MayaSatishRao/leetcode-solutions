class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            
            if(pq.size()<k)
                pq.add(arr[i]);
            else{
                int peekEl = pq.peek();
                if(Math.abs(peekEl-x)>Math.abs(arr[i]-x)){
                    pq.add(arr[i]);
                    pq.poll();
                }
            }
           
            
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(pq.poll());
        }
        
        Collections.sort(res);
        return res;
    }
}