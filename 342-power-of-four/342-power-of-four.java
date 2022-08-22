class Solution {
    public boolean isPowerOfFour(int n) {
        
   /* if(n==0)
        return false;
    
      if(n==1)
          return true;
      if(n%4!=0)
          return false;
        
        return isPowerOfFour(n/4);*/
        double r = Math.log(n)/Math.log(4);
        int r1 =(int) Math.floor(r);
        
        return r==r1;
    }
}