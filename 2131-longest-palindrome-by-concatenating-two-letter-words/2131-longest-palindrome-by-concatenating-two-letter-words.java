class Solution {
    public int longestPalindrome(String[] words) {
        boolean odd = false;
        int res=0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            if(hm.get(words[i])==null)
                hm.put(words[i],1);
            else
                hm.put(words[i],hm.get(words[i])+1);
        }
        
        for(int i=0;i<words.length && hm.size()>0 ; i++){
            
            if(hm.get(words[i])==null)
                continue;
            
            if(words[i].charAt(0)==words[i].charAt(1)){
                int freq = hm.get(words[i]);
                if(freq%2==1 && !odd){
                    res+=2*freq;
                    odd=true;
                }else if(freq%2==1 && odd)
                    res+=2*(freq-1);
                if(freq%2==0)
                    res+=2*freq;
            }else{
                String rev = "";
                rev+=words[i].charAt(1);
                  rev+=words[i].charAt(0);
            
               if(hm.get(rev)!=null){
                res+=4*Math.min(hm.get(words[i]),hm.get(rev));
                hm.remove(rev);
            } 
            }
            
            
            hm.remove(words[i]);
        }
        
        return res;
    }
}