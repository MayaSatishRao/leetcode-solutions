//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        int currSum=0,currLen=0,maxSum=0,maxLen=0,currStart=0,maxStart=0;
        for(int i=0;i<n;i++){
            if(a[i]>=0){
                currSum+=a[i];
                currLen++;
                
                if(currSum>maxSum){
                    maxSum=currSum;
                    maxLen=currLen;
                    maxStart=currStart;
                }else if(currSum==maxSum){
                    if(currLen>maxLen){
                       maxStart=currStart;
                       maxLen=currLen;
                    }
                      
                }
                
            }else{
                currStart=i+1;
                currLen=0;
                currSum=0;
            }
        }
        
       if(currSum>maxSum){
                    maxSum=currSum;
                    maxLen=currLen;
                    maxStart=currStart;
                }else if(currSum==maxSum){
                    if(currLen>maxLen){
                       maxStart=currStart;
                       maxLen=currLen;
                    }
                      
                }
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<maxLen;i++)
          arr.add(a[i+maxStart]);
        
        if(arr.size()==0)
        arr.add(-1);
        
        return arr;
    }
}