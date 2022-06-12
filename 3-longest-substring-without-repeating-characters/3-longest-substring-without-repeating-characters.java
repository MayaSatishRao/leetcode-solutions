class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0)
            return 0;
        
        HashSet<Character> hs = new HashSet<Character>();
        int start=0,end=0,res=0;
        
        while(end<s.length()){
            if(!hs.contains(s.charAt(end))){
                char ch = s.charAt(end);
                hs.add(ch);
                res=Math.max(res,hs.size());
                end++;
            }else{
                char ch = s.charAt(start);
                hs.remove(ch);
                start++;
            }
        }
        return res;
    }
}