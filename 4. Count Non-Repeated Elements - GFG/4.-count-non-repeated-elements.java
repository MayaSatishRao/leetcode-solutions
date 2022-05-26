// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        //Taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- >0)
        {
            //taking total count of elements
            int n=sc.nextInt();
            
            //Declaring and Initializing an array of size n
            int arr[] = new int[n];
            
            //Inserting elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
            //calling countNonRepeated method
            //of class Hashing and printing the result
            System.out.println(new Solution().countNonRepeated(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: input array
    // n: size of array
    
    //Function to return the count of non-repeated elements in the array.
    static long countNonRepeated(int arr[], int n)
    {
        // add your code
        HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(hm.get(arr[i])==null)
            hm.put(arr[i],1);
            else{
                int a = hm.get(arr[i]);
                hm.remove(arr[i]);
                hm.put(arr[i],a+1);
            }
            
        }
        
        long res=0;
        for(int i=0;i<n;i++){
            if(hm.get(arr[i])==1)
            res++;
        }
        return res;
    }
}