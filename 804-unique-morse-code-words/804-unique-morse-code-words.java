class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] alpha = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            String res="";
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                res+=alpha[ch-'a'];
            }
            hs.add(res);
        }
        
        return hs.size();
    }
}