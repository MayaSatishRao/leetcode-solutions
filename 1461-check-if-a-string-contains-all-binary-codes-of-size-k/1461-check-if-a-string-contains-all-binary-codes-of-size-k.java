class Solution {
    
    public int getState(String s){
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
            res |= 1<<i;
        }
        return res;
    }
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int totalSize = (int)Math.pow(2,k);
        
        for(int i=0;i<s.length()-k+1;i++){
            String a = s.substring(i,i+k);
            int hash = getState(a);
            //System.out.println(a);
            hs.add(hash);
            if(hs.size()==totalSize)
                return true;
        }
        
        if(hs.size()==totalSize)
                return true;
        
        return false;
    }
}