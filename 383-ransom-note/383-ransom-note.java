class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alp1 = new int[26];
        int[] alp2 = new int[26];
        
        for(int i=0;i<ransomNote.length();i++)
            alp1[ransomNote.charAt(i)-'a']++;
        
        for(int i=0;i<magazine.length();i++)
            alp2[magazine.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++)
            if(alp1[i]>alp2[i])
                return false;
        
        return true;
    }
}