class Solution {
    
    public boolean palindrome(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count++;
            for(int j=i+1;j<s.length();j++){
                if(palindrome(s.substring(i,j+1)))
                    count++;
            }
        }
        
        return count;
    }
}