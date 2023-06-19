//{ Driver Code Starts
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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int ceilIndex(ArrayList<Integer> arr, int key){
        int low=0, high=arr.size()-1;
        while(low<high){
            int mid = low+ (high-low)/2;
            
            if(arr.get(mid)>=key)
              high=mid;
            else
              low=mid+1;
        }
        return high;
    }
    
    public void reverse(int[] nums){
        int n = nums.length;
        int i=0, j=n-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            i++;
            j--;
        }
    }
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        int[] inc = new int[n];
        int[] dec = new int[n];
        
        inc[0] = 1;
        for(int i=1;i<nums.length;i++){
            if(arr.get(arr.size()-1)<nums[i]){
                arr.add(nums[i]);
                inc[i] = arr.size();
            }else{
                
                int index = ceilIndex(arr,nums[i]);
                //System.out.println(index);
                arr.set(index,nums[i]);
                inc[i] = index+1;
            }
        }
        
        arr = new ArrayList<>();
        reverse(nums);
        dec[0] = 1;
        
        //reverse the array
        
        arr.add(nums[0]);
        
        for(int i=1;i<nums.length;i++){
            if(arr.get(arr.size()-1)<nums[i]){
                arr.add(nums[i]);
                dec[i] = arr.size();
            }else{
                int index = ceilIndex(arr,nums[i]);
                arr.set(index,nums[i]);
                dec[i] = index+1;
            }
        }
        
        
        //System.out.println(Arrays.toString(inc));
        reverse(dec);
        //System.out.println(Arrays.toString(dec));
        int res=0;
        for(int i=0;i<n;i++){
            res = Math.max(res, inc[i]+dec[i]-1);
        }
        
        return res;
    }
}