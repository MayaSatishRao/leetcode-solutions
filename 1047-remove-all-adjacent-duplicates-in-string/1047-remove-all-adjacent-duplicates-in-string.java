class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            stk.push(s.charAt(i));
            while(stk.size()>1){
                char ch1 = stk.pop(), ch2 = stk.pop();
                if(ch1!=ch2){
                    stk.push(ch2);
                    stk.push(ch1);
                    break;
                }
            }
        }
        
        char[] ans = new char[stk.size()];
        int j = stk.size()-1;
        
        while(!stk.isEmpty()){
            ans[j--]=stk.pop();    
        }
        
        return new String(ans);
    }
}