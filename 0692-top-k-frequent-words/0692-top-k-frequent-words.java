class Data{
    String s;
    int f;
    Data(String a, int freq){
        s=a;
        f=freq;
    }
}

class DataComparator implements Comparator<Data>{
    public int compare(Data a, Data b){
        if(b.f==a.f)
                return a.s.compareTo(b.s);
            return b.f-a.f;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(hm.get(words[i])==null)
                hm.put(words[i],1);
            else
                hm.put(words[i],hm.get(words[i])+1);
        }
        
        PriorityQueue<Data> pq = new PriorityQueue<Data>(new DataComparator());
        for(Map.Entry<String,Integer> me: hm.entrySet()){
            pq.add(new Data(me.getKey(),me.getValue()));
        }
        
        List<String> res = new ArrayList<>();
        while(res.size()!=k){
            res.add(pq.poll().s);
        }
        
        return res;
    }
}