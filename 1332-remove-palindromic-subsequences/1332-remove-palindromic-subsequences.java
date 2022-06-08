class Solution {
    
    boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    public int removePalindromeSub(String s) {
       if(isPalindrome(s)) 
           return 1;
        else
            return 2;
    }
}