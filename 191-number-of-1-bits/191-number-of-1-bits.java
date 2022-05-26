public class Solution {
    // you need to treat n as an unsigned value
 /*   int[] table=new int[256];
    
    void initialize(){
        table[0]=0;
        for(int i=1;i<256;i++){
            table[i]=(i&1)+table[i/2];
        }
    }*/
    
    public int hammingWeight(int n) {
       /* initialize();
        int res=table[n&0xff];
        n=n>>8;
        
        res=res+table[n&0xff];
        n=n>>8;
        
        res=res+table[n&0xff];
        n=n>>8;
        
        res=res+table[n&0xff];
        return res;*/
        int res=0;
        while(n!=0){
            n=n&(n-1);
            res++;
        }
        return res;
    }
}