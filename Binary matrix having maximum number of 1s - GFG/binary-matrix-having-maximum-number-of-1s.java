//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class GfG {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0) {
            int B = sc.nextInt();
            int arr[][] = new int[B][B];
            for(int i = 0; i < B; i++) {
                for(int j = 0; j < B; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int ans[] = obj.findMaxRow(arr, B);
            for(int i = 0; i < 2; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int binarySearch(int[] arr){
        int n= arr.length;
        int low=0,high=n-1;
        
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(arr[mid]==1){
                ans=mid;
                high=mid-1;
            }else
              low=mid+1;
        }
        
        return ans;
    }
    public int[] findMaxRow(int mat[][], int N) {
        // code here
        int row=0,count=0;
        for(int i=0;i<N;i++){
            int pos = binarySearch(mat[i]);
            if(pos>=0 && N-pos>count){
                count=N-pos;
                //System.out.println(N+" "+pos);
                row=i;
            }
        }
        return new int[]{row,count};
    }
};