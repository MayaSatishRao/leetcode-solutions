class Solution {
    
    public int[] getDigit(int n){
        int[] freq1 = new int[10];
        int temp=n;
        while(temp>0){
            freq1[temp%10]++;
            temp/=10;
        }
        
        return freq1;
    }
    
    public int digits(int n){
        return (int)Math.floor(Math.log(n)/Math.log(10))+1;
    }
    public boolean reorderedPowerOf2(int n) {
        int curr=1,d=digits(n);
        int[] freq1 = getDigit(n);
        
        while(digits(curr)<=d){
            int[] freq2 = getDigit(curr);
            
            int i=0;
            for(i=0;i<10;i++)
                if(freq1[i]!=freq2[i])
                    break;
            if(i==10)
                return true;
            curr*=2;
            
        }
        
        return false;
    }
}