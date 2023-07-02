//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
      /*  int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0] = arr[i];
            a[i][1] = i;
        }
        
        Arrays.sort(a,(x,y)->{
            return x[0]-y[0];
        });
        
        int minIndex = Integer.MAX_VALUE, res=0;
        for(int i=0;i<n;i++){
            minIndex = Math.min(minIndex,a[i][1]);
            res = Math.max(res, a[i][1] - minIndex);
        }
        
        return res;*/
        
        int[] lMin = new int[n];
        int[] rMax = new int[n];
        
        int min = arr[0];
        for(int i=0;i<n;i++){
            min = Math.min(min,arr[i]);
            lMin[i] = min;
        }
        
        int max = arr[n-1];
        for(int i=n-1;i>=0;i--){
            max = Math.max(max,arr[i]);
            rMax[i] = max;
        }
        
        int i=0,j=0,res=0;
        while(i<n && j<n){
            while(j<n && rMax[j]>=lMin[i])
              j++;
            res = Math.max(res, j-i-1);
            while(i<n && j<n && lMin[i]>=rMax[j])
              i++;
        }
        
        return res;
    }
}