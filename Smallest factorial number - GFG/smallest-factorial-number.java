// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int power5(int n){
        int c=0,p=5;
        while(p<=n){
            c+=n/p;
            p*=5;
        }
        return c;
    }
    int findNum(int n)
    {
        // Complete this function
        int low=1,high=5*n;
        while(low<high){
            int mid = (low+high)/2;
            
            if(power5(mid)<n)
            low=mid+1;
            else
            high=mid;
        }
        
        return low;
    }
}