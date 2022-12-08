//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    
    static boolean isPrime(long n){
        if(n==1 || n==0)
        return false;
        if(n==2 || n==3)
         return true;
        if(n%2==0 || n%3==0)
        return false;
        
        for(long i=5;i*i<=n;i+=6)
           if(n%i==0 || n%(i+2)==0)
             return false;
        
        return true;
    }
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<q;i++){
            long n = query.get(i);
            int count=0;
            for(long j=1;j*j<=n;j++)
              if(isPrime(j))
                count++;
            res.add(count);
            
        }
        
        return res;
    }
}