//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static int numSubarrays(int[] arr, int sum){
        int count=0,curr=0;
        for(int i=0;i<arr.length;i++){
            if(curr+arr[i]<=sum)
            curr+=arr[i];
            else{
                count++;
                curr=arr[i];
            }
        }
        count++;
        return count;
    }
    
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int sum=arr[0],max=arr[0];
        for(int i=1;i<N;i++){
            max=Math.max(arr[i],max);
            sum+=arr[i];
        }
        
        int low=max, high=sum,res=0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int ans = numSubarrays(arr,mid);
            
           // System.out.println(mid+" "+ans);
            if(ans<=K){
                res=mid;
                high=mid-1;
            }
             
            else
             low=mid+1;
             
        }
        
        
        return res;
        
    }
};