// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            String a = "";
            a = sc.next();
            System.out.println(new Solution().modified(a));
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find minimum number of characters which Ishaan must insert  
    //such that string doesn't have three consecutive same characters.
    public static long modified(String a)
    {
        // Your code here
        long res=0;
        if(a.length()<=2)
        return res;
        
        char prev = a.charAt(0);
        int freq = 1;
        for(int i=1;i<a.length();i++){
            if(a.charAt(i)==prev)
            freq++;
            if(freq==3){
               res++;
               freq=1;
            }else if(a.charAt(i)!=prev)
            freq=1;
            prev=a.charAt(i);
        }
        
        return res;
    }
}