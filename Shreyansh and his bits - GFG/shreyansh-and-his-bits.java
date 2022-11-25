//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long comb(int n, int r){
         //System.out.println(n+" "+r);
        if(r>n || n<=0 || r<0)
        return 0;
        if(r==0)
        return 1;
        
        if(r>n-r)
        r=n-r;
        
        long ans=1;
        for(int i=1;i<=r;i++){
          ans*=(n-r+i);
          ans/=i;
        }
        return ans;
    }
    long count(long n)
    {
        // Code Here
        int[] count= new int[40];
        int index=39,total=0;
        
        while(n>0){
            int bit = (int)(n%2);
            if(bit==1){
               count[index]=1;
               total++;
            }
              
            index--;
            n/=2;
        }
        //System.out.println(Arrays.toString(count));
        long ans=0;
        for(int i=0;i<40;i++){
            if(count[i]==1){
                ans+=comb(39-i,total);
                total--;
            }
           
        }
        
        return ans;
    }
}