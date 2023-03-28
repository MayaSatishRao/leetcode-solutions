//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
      HashMap<Integer,Integer> hm = new HashMap<>();
      hm.put(0,1);
      
      int res=0,sum=0;
      for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(ch>='a' && ch<='z')
               sum++;
            else
                sum--;
             if(hm.get(sum)!=null)
               res+=hm.get(sum);
             hm.put(sum,hm.getOrDefault(sum,0)+1);
          
      }
      
      return res;
    }
} 
