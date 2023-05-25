//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static boolean isNum(char ch){
        return ch>='0' && ch<='9';
    }
    
    public static boolean toPop(char ch1, char ch2){
        if(ch1=='+' && ch2=='*')
           return false;
        if(ch1=='-' && ch2=='*')
           return false;
           
        return true;
    }
    
    public static long calculate(long a, long b, char ch){
        if(ch=='+')
          return a+b;
        if(ch=='-')
          return b-a;
        if(ch=='*')
          return a*b;
        return -1;
    }
    
    public static long compute(String exp){
        Stack<Long> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        
        int i=0;
        while(i<exp.length()){
            char ch = exp.charAt(i);
            if(isNum(ch)){
                int start=i;
                while(i<exp.length() && isNum(exp.charAt(i)) )
                  i++;
                //System.out.println(exp.substring(start,i));
                long n = Long.parseLong(exp.substring(start,i));
                num.push(n);
                
            }else{
                while(!op.isEmpty() && toPop(op.peek(),ch)){
                    long p = num.pop(), q = num.pop();
                    char o = op.pop();
                    long res = calculate(p,q,o);
                    num.push(res);
                }
                op.push(ch);
                i++;
            }
            
            
        }
        
        while(num.size()>1){
            long p = num.pop(), q = num.pop();
            char o = op.pop();
            long res = calculate(p,q,o);
            num.push(res);
            
        }
        
        return num.pop();
    }
    
    public static void getExp(String curr, int index, long target, ArrayList<String> res){
         if(index>=curr.length()-1){
             long ans = compute(curr);
             if(ans==target)
               res.add(curr);
             return ;
         }
         
         // nothing
         if(curr.charAt(index)!='0')
         getExp(curr,index+1,target,res);
         
         String left = curr.substring(0,index+1);
         String right = curr.substring(index+1,curr.length());
         
         // add +
         String exp = new String(left+"+"+right);
         getExp(exp,index+2,target,res);
         // sub -
         exp = new String(left+"-"+right);
         getExp(exp,index+2,target,res);
         // mul *
         exp = new String(left+"*"+right);
         getExp(exp,index+2,target,res);
         
    }
    
    public static void getResult(String S, String curr,int index, long target, long res, long prev, ArrayList<String> ans){
        if(index>=S.length()){
            if(res==target)
              ans.add(curr);
            return ;
        }
        
        
        for(int i=index;i<S.length();i++){
            
            if(i>index && S.charAt(index)=='0')
              break;
              
            String left = S.substring(index,i+1);
            long l = Long.parseLong(left);
            
            if(index==0){
                getResult(S,curr+left,i+1,target,res+l,l,ans);
            }else{
                getResult(S,curr+"+"+left,i+1,target,res+l,l,ans);
                getResult(S,curr+"-"+left,i+1,target,res-l,-l,ans);
                getResult(S,curr+"*"+left,i+1,target, res-prev+prev*l,prev*l,ans);
            }
        }
    }
    
    public static ArrayList<String> addOperators(String S, int target) {
        // code here
        //System.out.println(compute("10*25*30"));
        ArrayList<String> res = new ArrayList<String>();
        
        getResult(S,"",0,(long)target,(long)0,(long)0,res);
        return res;
    }
}
