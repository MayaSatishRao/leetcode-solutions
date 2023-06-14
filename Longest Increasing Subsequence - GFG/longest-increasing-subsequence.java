//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int binarySearch(ArrayList<Integer> arr, int key){
        int low=0,high=arr.size()-1;
        int res=0;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr.get(mid)<=key){
                low=mid+1;
            }else{
                res=mid;
                high=mid-1;
            }
              
        }
        
        return res;
    }
    
    static int longestSubsequence(int n, int a[])
    {
        // code here
       ArrayList<Integer> arr = new ArrayList<>();
       arr.add(a[0]);
       
       for(int i=1;i<n;i++){
           if(arr.get(arr.size()-1)<a[i])
             arr.add(a[i]);
           else{
               int index = binarySearch(arr,a[i]);
               arr.set(index,a[i]);
           }
       }
       
       return arr.size();
    }
} 