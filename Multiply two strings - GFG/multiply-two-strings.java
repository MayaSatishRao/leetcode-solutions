//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        boolean neg = false;
        if(s1.charAt(0)=='-'){
            s1 = s1.substring(1);
            neg^=true;
        }
        if(s2.charAt(0)=='-'){
            s2 = s2.substring(1);
            neg^=true;
        }
         
        int n1=s1.length(), n2=s2.length();
        
        int[] dp = new int[n1+n2];
        int start=n1+n2-1;
        
        
        for(int i=n1-1;i>=0;i--){
            int carry=0,a=s1.charAt(i)-48,shift=0;
            
            for(int j=n2-1;j>=0;j--){
                int b = s2.charAt(j)-48;
                int product = a*b, temp = dp[start-shift];
                //System.out.println(product+" "+carry);
                dp[start-shift]=(temp+product+carry)%10;
                carry = (temp+product+carry)/10;
                shift++;
            }
            if(carry!=0){
                dp[start-shift]=carry+dp[start-shift];
            }
            start--;
            //System.out.println(Arrays.toString(dp));
        }
        
        int i=0;
        while(i<dp.length-1 && dp[i]==0)
          i++;
        
        String res="";
        int j=dp.length-1;
        while(j>=i){
            char ch = (char)(dp[j]+'0');
            res = ch+res;
            j--;
        }
        
        if(neg)
         res="-"+res;
        return res;
    }
}