class Solution {
    public int firstUniqChar(String s) {
        int[] alpha  = new int[26];
        
        for(int i=0;i<s.length();i++){
            int index = (int)s.charAt(i)-97;
            alpha[index]++;
        }
        
        for(int i=0;i<s.length();i++){
            int index = (int)s.charAt(i)-97;
            if(alpha[index]==1)
                return i;
        }
        
        return -1;
    }
}