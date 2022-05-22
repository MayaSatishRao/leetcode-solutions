class Solution {
    
    public int palindrome(String s,int left,int right){
        int count=0;
        while(left>=0 && right<=s.length()-1){
                if(s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                    count++;
                }else
                    break;
            }
        return count;
    }
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count++;
            int left=i-1,right=i+1;
            count+=palindrome(s,i-1,i+1);
            count+=palindrome(s,i,i+1);
        }
        
        return count;
    }
}