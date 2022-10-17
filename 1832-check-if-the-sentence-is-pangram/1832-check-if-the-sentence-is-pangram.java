class Solution {
    public boolean checkIfPangram(String sentence) {
        TreeSet<Character> ts = new TreeSet<>();
        if(sentence.length()<26)
            return false;
        
        int i=0;
        while(i<sentence.length()){
            ts.add(sentence.charAt(i));
            if(ts.size()==26)
                return true;
            i++;
        }
        return false;
    }
}