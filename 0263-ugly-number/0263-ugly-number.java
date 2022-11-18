class Solution {
    public boolean isUgly(int n) {
        if(n<=0)
            return false;
        
        while(n>1){
            boolean found=false;
            if(n%2==0){
                n=n/2;
                found=true;
            }
            if(n%5==0){
                n=n/5;
                found=true;
            }
            if(n%3==0){
                n=n/3;
                found=true;
            }
            if(!found)
                return false;
        }
        return true;
    }
}