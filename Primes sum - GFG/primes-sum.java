//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    static boolean isPrime(int n){
        if(n==1)
        return false;
        if(n==2 || n==3)
        return true;
        if(n%2==0 || n%3==0)
        return false;
        
        for(int i=5;i*i<=n;i+=6)
           if(n%i==0 || n%(i+2)==0)
              return false;
       
       return true;
    }
    static String isSumOfTwo(int N){
        // code here
        if(N%2==1){
            if(isPrime(N-2))
              return "Yes";
            return "No";
        }
      
      if(isPrime(N-2))
              return "Yes";  
        
        
        for(int i=3;i<=N/2;i+=2){
            if(isPrime(i) && isPrime(N-i))
               return "Yes";
        }
        
        return "No";
    }
}