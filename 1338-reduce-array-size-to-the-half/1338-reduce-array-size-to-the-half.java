

class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(hm.get(arr[i])==null)
                hm.put(arr[i],1);
            else
                hm.put(arr[i],hm.get(arr[i])+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Iterator hmi =  hm.entrySet().iterator();
        
        while(hmi.hasNext()){
            Map.Entry mp = (Map.Entry)hmi.next();
            int freq = (int)mp.getValue();
            pq.add(freq);
        }
        
        int res=0,curr=0;
        while(curr<arr.length/2){
            curr+=pq.poll();
            res++;
        }
        
        return res;
    }
}