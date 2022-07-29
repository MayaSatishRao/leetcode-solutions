class Solution {
    
    public boolean mapping(String s, String pat){
            HashMap<Character,Character> hm1 = new HashMap<Character,Character>();
            HashSet<Character> hm2 = new HashSet<>();
        
            for(int j=0;j<s.length();j++){
                char ch1 = s.charAt(j), ch2=pat.charAt(j);
                if(hm1.get(ch1)==null){
                     if(hm2.contains(ch2)==false){
                         hm1.put(ch1,ch2);
                         hm2.add(ch2);
                     }else
                         return false;
                     
                }else{
                    if(hm1.get(ch1)!=ch2)
                        return false;
                }
            }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            if(pattern.equals(words[i])){
                res.add(words[i]);
                continue;
            }
            if(words[i].length()!=pattern.length())
                continue;
            
            if(mapping(words[i],pattern))
               res.add(words[i]);
            
        }
        
        return res;
    }
}