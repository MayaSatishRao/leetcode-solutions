class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        int temp=k;
        
        for(int i=0;i<num.length();i++){
            while(!stk.isEmpty() && k>0 && stk.peek()>num.charAt(i)){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }
        
        while(stk.size()>num.length()-temp)
            stk.pop();
        
        String res="";
        while(!stk.isEmpty())
            res+=stk.pop();
        
        if(res.length()==0)
            res="0";
        
        res = new StringBuilder(res).reverse().toString();
        int i=0;
        while(i<res.length()-1 && res.charAt(i)=='0')
            i++;
        
        return res.substring(i,res.length());
    }
}