class Solution {
    public List<Integer> intersection(int[][] nums) {
       // TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
        int[] freq = new int[1001];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                freq[nums[i][j]]++;
                  
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i=1;i<1001;i++)
            if(freq[i]==nums.length)
                res.add(i);
        
        return res;
    }
}