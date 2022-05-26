// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- >0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n=Integer.parseInt(str[0]);
            int arr[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            ArrayList<Integer> v = new Solution().printNonRepeated(arr, n);
            
            for(int i=0;i<v.size();i++){
                System.out.print(v.get(i)+" ");
            }
            
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return non-repeated elements in the array.
    static ArrayList<Integer> printNonRepeated(int arr[], int n)
    {
        // add your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
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
        
        
        for(int i=0;i<n;i++){
            if(hm.get(arr[i])==1)
            res.add(arr[i]);
        }
        return res;
    }
}

