class Solution {
    
    public boolean match(char a, char b){
        if(a+32==b || b+32==a)
            return true;
        return false;
    }
    
    public String reverse(String s){
        String res="";
        int j=s.length()-1;
            while(j>=0){
                res+=s.charAt(j);
                j--;
            }
        return res;
    }
    
    public String makeGood(String s) {
       if(s.length()==0)
           return s;
        ArrayDeque<Character> stk = new ArrayDeque<Character>();
        
        for(int i=0;i<s.length();i++){
                stk.push(s.charAt(i));
                while(stk.size()>=2){
                    char a = stk.pop(), b=stk.pop();
                    if(!match(a,b)){
                        stk.push(b);
                        stk.push(a);
                        break;
                    }
                }
            }
        
        
        String res = new String();
        
        while(!stk.isEmpty())
            res+=stk.pop();
        
        if(res.length()<=1)
            return res;
        else{
          return reverse(res);  
        }
        
    }
}