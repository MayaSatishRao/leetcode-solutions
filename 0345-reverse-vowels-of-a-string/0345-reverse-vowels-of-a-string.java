class Solution {
    
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
            return true;
        
        return false;
    }
    public String reverseVowels(String s) {
        ArrayList<Character> arr = new ArrayList<Character>();
        char[] str = s.toCharArray();
        
        for(int i=0;i<s.length();i++)
            if(isVowel(s.charAt(i)))
                arr.add(s.charAt(i));
        
        int j = arr.size()-1;
        for(int i=0;i<s.length();i++){
            if(isVowel(str[i])){
                str[i]=arr.get(j);
                j--;
            }        
        }
        
        return new String(str);
        
    }
}