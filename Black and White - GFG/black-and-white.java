//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    
    static int count(int r, int c, int n, int m){
        
        int res=0;
        
        if(r-2>=0 && c-1>=0)
        res++;
        if(r-2>=0 && c+1<m)
        res++;
        if(r-1>=0 && c-2>=0)
        res++;
        if(r-1>=0 && c+2<m)
        res++;
        if(r+1<n && c-2>=0)
        res++;
        if(r+1<n && c+2<m)
        res++;
        if(r+2<n && c-1>=0)
        res++;
        if(r+2<n && c+1<m)
        res++;
        
        return res;
    }
    static long numOfWays(int N, int M)
    {
        // add your code here
        long res=0;
        int p = (int)Math.pow(10,9)+7;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                
                 res = (res+(N*M-1-count(i,j,N,M)))%p;
            }
        }
        return res;
    }
}