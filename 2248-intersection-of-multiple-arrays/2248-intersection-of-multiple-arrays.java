class Solution {
    public List<Integer> intersection(int[][] nums) {
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(tm.get(nums[i][j])==null)
                    tm.put(nums[i][j],1);
                else
                    tm.put(nums[i][j],1+tm.get(nums[i][j]));
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(Map.Entry el: tm.entrySet()){
            int freq = (int)el.getValue();
            int a = (int)el.getKey();
            
            if(freq==nums.length)
                res.add(a);
        }
        
        return res;
    }
}