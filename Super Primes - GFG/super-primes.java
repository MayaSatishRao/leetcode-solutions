// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.superPrimes(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    boolean binarySearch(int n, ArrayList<Integer> arr){
        int low=0,high=arr.size()-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(arr.get(mid)==n)
            return true;
            
            if(arr.get(mid)>n)
            high=mid-1;
            else
            low=mid+1;
        }
        
        return false;
    }
    
    boolean isPrime(int n){
        if(n==0 || n==1)
        return false;
        
        if(n==2 || n==3)
        return true;
        
        if(n%2==0 || n%3==0)
        return false;
        
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0)
            return false;
        }
        
        return true;
    }
    int superPrimes(int n) {
        // code here
        
        
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for(int i=2;i<=n;i++)
        if(isPrime(i))
        prime.add(i);
        
         //System.out.println(prime);
        
        int count=0;
        for(int i=2;i<prime.size();i++){
            int p = prime.get(i);
            
            if(binarySearch(p-2,prime)){
               
                count++;
            }
            
        }
        
        return count;
        
    }
}