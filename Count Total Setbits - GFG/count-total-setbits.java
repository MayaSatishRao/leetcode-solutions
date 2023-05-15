//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int[] lookUpTable(){
        int[] table = new int[256];
        
        for(int i=1;i<256;i++)
          table[i] = (i&1)+table[i/2];
        
        return table;
    }
    public static long countBits(long N) {
        // code here
        // 0-0, 1-1, 2-1, 3-2, 4-1, 5-2, 6-2, 7-3
        int[] table = lookUpTable();
        long res=0;
        
        for(long i=1;i<=N;i++){
            long j = i;
            res+=table[(int)(j&255)];
            j = j>>8;
            
            res+=table[(int)(j&255)];
            j = j>>8;
            
            res+=table[(int)(j&255)];
            j = j>>8;
            
            res+=table[(int)(j&255)];
        }
        
        return res;
    }
}
        
