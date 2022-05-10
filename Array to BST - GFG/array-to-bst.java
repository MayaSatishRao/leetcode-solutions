// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void constructTree(int[] nums, int low, int high, ArrayList<Integer> arr){
        if(high<0 || low>=nums.length || low>high)
        return ;
        int mid = low+(high-low)/2;
        arr.add(nums[mid]);
        constructTree(nums,low,mid-1,arr);
        constructTree(nums,mid+1,high,arr);
    }
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
       ArrayList<Integer> arr = new ArrayList<Integer>();
       constructTree(nums,0,nums.length-1,arr);
       
       int[] res = new int[nums.length];
       for(int i=0;i<nums.length;i++)
       res[i]=arr.get(i);
       
       return res;
        
    }
}