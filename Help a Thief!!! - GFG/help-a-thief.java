// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}// } Driver Code Ends

class Pair{
    int plates;
    int coins;
    
    Pair(int a, int b){
        plates=a;
        coins=b;
    }
}
class Solution {
    static int maxCoins(int[] A, int[] B, int T, int N) {
        // code here
        Pair[] arr = new Pair[N];
        for(int i=0;i<N;i++)
        arr[i]=new Pair(A[i],B[i]);
        
        Arrays.sort(arr,(a,b)->b.coins-a.coins);
        
        int i=0,res=0;
        while(i<N && T>0){
            if(arr[i].plates>T){
                res+=T*arr[i].coins;
                T=0;
            }else{
                res+=arr[i].plates*arr[i].coins;
                T-=arr[i].plates;
            }
            i++;
        }
        return res;
    }
}