// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    
    
    
    static void toh(int N,int src,int mid, int des,int n,ArrayList<Integer[]> moves){
        if(N==1){
            Integer[] arr = new Integer[2];
            arr[0]=src;
            arr[1]=des;
            moves.add(arr);
            return ;
        }
        if(moves.size()>n)
        return ;
        toh(N-1,src,des,mid,n,moves);
        Integer[] arr = new Integer[2];
            arr[0]=src;
            arr[1]=des;
            moves.add(arr);
        //System.out.println(moves+" "+src+" "+des);
        toh(N-1,mid,src,des,n,moves);
        
    }
    static List<Integer> shiftPile(int N, int n){
        // code here
        ArrayList<Integer[]> moves = new ArrayList<Integer[]>();
        toh(N,1,2,3,n,moves);
        List<Integer> res = new ArrayList<Integer>();
        res.add(moves.get(n-1)[0]);
        res.add(moves.get(n-1)[1]);
        
        return res;
    }
}