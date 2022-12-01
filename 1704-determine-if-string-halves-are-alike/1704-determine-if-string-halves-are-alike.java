class Solution {
    
    public boolean isVowel(char ch){
        if((int)ch<97)
            ch=(char)(ch+32);
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }
    public boolean halvesAreAlike(String s) {
        int v1=0,v2=0;
        for(int i=0;i<s.length()/2;i++)
            if(isVowel(s.charAt(i)))
                v1++;
        
        for(int i=s.length()/2;i<s.length();i++)
            if(isVowel(s.charAt(i)))
                v2++;
        
        return v1==v2;
    }
}