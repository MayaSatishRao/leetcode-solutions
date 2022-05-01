class Solution {
    public boolean backspaceCompare(String s, String t) {
      /*   ArrayDeque<Character> stk = new ArrayDeque<Character>();
        
         for(int i=0;i<s.length();i++){
             if(Character.isLetter(s.charAt(i)))
                 stk.push(s.charAt(i));
             else if(!stk.isEmpty() && s.charAt(i)=='#')
                 stk.pop();
         }
        
        String s1=new String();
        while(!stk.isEmpty())
            s1+=stk.pop();
        
        for(int i=0;i<t.length();i++){
             if(Character.isLetter(t.charAt(i)))
                 stk.push(t.charAt(i));
             else if(!stk.isEmpty() && t.charAt(i)=='#')
                 stk.pop();
         }
        
        String t1=new String();
        while(!stk.isEmpty())
            t1+=stk.pop();
        
        if(s1.equals(t1))
            return true;
        else 
            return false;*/
        
        int i=s.length()-1, j=t.length()-1,delete1=0,delete2=0;
        
        while(i>=0 || j>=0){
            
            while(i>=0){
                if(s.charAt(i)=='#'){
                    delete1++;
                    i--;
                }else if(delete1>0){
                    delete1--;
                    i--;
                }else
                   break;       
            }
            
            while(j>=0){
                if(t.charAt(j)=='#'){
                    delete2++;
                    j--;
                }else if(delete2>0){
                    delete2--;
                    j--;
                }else
                    break;
            }
            
            if( (i>=0) != (j>=0) )
                return false;
            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))
                return false;
            
            i--;
            j--;
        }
        return true;
    }
}