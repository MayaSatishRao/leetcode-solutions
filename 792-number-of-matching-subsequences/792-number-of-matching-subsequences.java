class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        HashMap<String,Integer> hs = new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
            hs.put(words[i],hs.getOrDefault(words[i],0)+1);
        }
        
        
       
        for(String a: hs.keySet()){
            
            int j = 0;
            int k=0;
            while(j<a.length() && k<s.length()){
                if(s.charAt(k)==a.charAt(j)){
                    j++;
                }
                k++;
            }
            if(j==a.length()){
               count+=hs.get(a);
            }
                
        }
        return count;
    }
}