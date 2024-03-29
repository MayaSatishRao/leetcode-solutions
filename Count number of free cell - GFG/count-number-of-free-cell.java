//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine().trim());
        while(T>0)
        {
            String s[]=in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[][] a = new int[k][2];
            for(int i=0; i<k; i++){
                s=in.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            Solution g = new Solution();
            long[] res = g.countZero(n,k,a);
            
            for(int i=0; i<res.length; i++){
                out.print(res[i]+" ");
            }
            out.println();
            T--;
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    long[] countZero(int N, int K, int[][] arr){
        // code here
        
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        long[] res = new long[K];
        long ones=0;
        
        for(int i=0;i<K;i++){
            int r = arr[i][0]-1, c=arr[i][1]-1, rowInc=0, colInc=0;
            boolean rNew=false, cNew = false;
            
            if(!row.contains(r)){
                rowInc+=(N-col.size());
                rNew=true;
                
            }
            if(!col.contains(c)){
                colInc+=(N-row.size());
                
                cNew=true;
            }
            row.add(r);
            col.add(c);  
            
            if(rNew && cNew)  
            ones+=(rowInc+colInc-1);
            else
            ones+=(rowInc+colInc);
            
            //System.out.println(rowInc+" "+colInc+" "+ones);
            res[i] = (N*N)-ones;
        }
        
        return res;
    }
}