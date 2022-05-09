// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
 
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here 
        ArrayList <String> res = new ArrayList <String>();
        String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Queue<String> q = new LinkedList<String>();
        q.add("");
        
        for(int i=0;i<a.length;i++){
            String b = arr[a[i]];
            
            int c = q.size();
            for(int j=0;j<c;j++){
                String permute = q.poll();
                for(int k=0;k<b.length();k++){
                    q.add(permute+b.charAt(k));
                }
                
                
            }
        }
        
        
        while(!q.isEmpty())
        res.add(q.poll());
        
        return res;
    }
}


