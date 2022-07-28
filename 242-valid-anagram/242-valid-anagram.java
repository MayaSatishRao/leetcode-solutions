class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        int[] alps = new int[26];
        for(int i=0;i<s.length();i++)
            alps[(int)s.charAt(i)-97]++;
        
        int[] alpt = new int[26];
        for(int i=0;i<t.length();i++)
            alpt[(int)t.charAt(i)-97]++;
        
        for(int i=0;i<26;i++)
            if(alps[i]!=alpt[i])
                return false;
        
        return true;
    }
}