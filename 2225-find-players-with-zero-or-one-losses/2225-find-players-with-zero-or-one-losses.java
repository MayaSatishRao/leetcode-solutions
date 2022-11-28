class Player{
    int id,win,loss;
    Player(int a, int b, int c){
        id=a;
        win=b;
        loss=c;
    }
}

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Player> hm = new HashMap<>();
        for(int i=0;i<matches.length;i++){
            int w = matches[i][0], l=matches[i][1];
            if(hm.get(w)==null)
                hm.put(w,new Player(w,1,0));
            else
                hm.get(w).win++;
            
            if(hm.get(l)==null)
                hm.put(l,new Player(l,0,1));
            else
                hm.get(l).loss++;
            
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        
        Set<Map.Entry<Integer,Player>> entries = hm.entrySet();
        for(Map.Entry<Integer,Player> me: entries){
            Player p = me.getValue();
           // System.out.println((me.getKey()==340)+" "+p.loss);
            if(p.loss==0)
                ans.get(0).add(me.getKey());
            else if(p.loss==1)
                ans.get(1).add(me.getKey());
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}