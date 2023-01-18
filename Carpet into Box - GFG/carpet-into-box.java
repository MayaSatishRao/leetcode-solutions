//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    int folds(int A, int C){
        int i=0;
         for(;;i++){
             if((A/(int)Math.pow(2,i))<=C)
               break;
         }
         return i;
    }
    int carpetBox(int A, int B, int C, int D) { 
        //code here
         int tempa = A, tempb=B;
         int ans=Integer.MAX_VALUE;
         ans=Math.min(ans,folds(A,C)+folds(B,D));
         ans=Math.min(ans,folds(A,D)+folds(B,C));
         return ans;
    }
   
}
