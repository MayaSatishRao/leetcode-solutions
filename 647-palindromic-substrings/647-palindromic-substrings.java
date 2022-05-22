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
            int left=i-1,right=i+1;
            while(left>=0 && right<=s.length()-1){
                if(s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                    count++;
                }else
                    break;
            }
            left=i;
            right=i+1;
            
            while(left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }else
                    break;
            }
        }
        
        return count;
    }
}