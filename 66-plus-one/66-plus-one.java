class Solution {
    public int[] plusOne(int[] digits) {
       int carry=0,index=digits.length-1;
        do{
            carry=(digits[index]+1)/10;
            digits[index]=(digits[index]+1)%10;
            index--;
        }while(carry!=0 && index>=0);
        
         if(digits[0]==0){
             int[] res = new int[digits.length+1];
             res[0]=1;
             for(int i=0;i<digits.length;i++)
                 res[i+1]=digits[i];
             
             return res;
         }  
        return digits;
    }
}