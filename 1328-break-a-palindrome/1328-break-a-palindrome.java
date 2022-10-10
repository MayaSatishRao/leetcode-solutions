class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1)
            return new String();
        String res=(palindrome.charAt(0)!='a')?"a":"b";
        res+=palindrome.substring(1,palindrome.length());
        
        for(int i=1;i<palindrome.length();i++){
            
            if(palindrome.length()%2==1 && i==palindrome.length()/2)
                continue;
            
            String temp = palindrome.substring(0,i);
            temp+=(palindrome.charAt(i)!='a')?"a":"b";
            temp+=palindrome.substring(i+1,palindrome.length());
            
            if(res.compareTo(temp)>0)
                res=temp;
        }
        
        return res;
    }
}