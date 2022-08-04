class Solution {
    public int reverse(int n){
        int res=0;
        while(n>0){
            int digit=n%10;
            res=res*10+digit;
            n/=10;
        }
        return res;
    }
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else{
            if(reverse(x)==x)
                return true;
            else
                return false;
        }
            
    }
}