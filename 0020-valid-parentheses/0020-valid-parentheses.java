class Solution {
    public boolean isMatching(char a,char b){
        return ((a=='(' && b==')')||(a=='{' && b=='}')||(a=='[' && b==']'));
    }
    
    public boolean isValid(String str) {
        
        Deque<Character> s = new ArrayDeque<Character>();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
                s.push(ch);
            else{
                if(s.isEmpty())
                    return false;
                else if(isMatching(s.peek(),ch))
                    s.pop();
                else
                    return false;
                    
            }
        }
        
        return (s.isEmpty()==true);
        
    }
}