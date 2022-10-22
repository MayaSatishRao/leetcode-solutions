class Solution {
    public String minWindow(String s, String t) {
        int i=0;
        HashMap<Character,Integer> chars = new HashMap<>();
        for(int k=0;k<t.length();k++){
            if(chars.get(t.charAt(k))==null)
                chars.put(t.charAt(k),1);
            else
                chars.put(t.charAt(k), chars.get(t.charAt(k))+1);
        }
        
        String res=s;
        boolean found=false;
        HashMap<Character, Integer> hm = new HashMap<>();
        int start=0,j=0,matchCount=0;
        
        while(i<s.length()){
            int k=0;
            while(j<s.length() && matchCount<t.length()){
                char ch = s.charAt(j);
                if(chars.get(ch)!=null && (hm.get(ch)==null || hm.get(ch)<chars.get(ch)))
                    matchCount++;
                if(hm.get(ch)==null)
                    hm.put(ch,1);
                else
                    hm.put(ch, hm.get(ch)+1);
                j++;
               // System.out.println(hm.get(ch)+" "+chars.get(ch));
            }
           // System.out.println(start);
            if(matchCount==t.length()){
                found=true;
                for( k=start;k<=j && k<s.length();k++){
                    char ch = s.charAt(k);
                    if(chars.get(ch)==null || hm.get(ch)>chars.get(ch)){
                        hm.put(ch,hm.get(ch)-1);
                        start++;
                    }else{
                        hm.put(ch,hm.get(ch)-1);
                        matchCount--;
                        break;
                    }
                        
                }
                if(j-start<=res.length())
                    res=s.substring(start,j);
                start++;
                //System.out.println(start+" "+j);
            }
            i=j;
            //System.out.println(i);
        }
        if(found)
            return res;
        
        return new String();
        
    }
}