class Solution {
    public int maximum69Number (int num) {
       /* String str = Integer.toString(num);
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)=='6'){
                    str = str.substring(0,i)+'9'+str.substring(i+1);
                    break;
            }
        return Integer.parseInt(str);*/
        
        int res=0;
        int digits = (int)(Math.log(num)/Math.log(10));
        boolean change = false;
        
        while(digits>=0){
            int rem = num/(int)Math.pow(10,digits);
            if(rem==6 && !change){
                change=true;
                rem=9;
            }
            //System.out.println(rem);
            res+=rem*(int)Math.pow(10,digits);
            num=num%(int)Math.pow(10,digits);
            digits--;
        }
        
        return res;
    }
}