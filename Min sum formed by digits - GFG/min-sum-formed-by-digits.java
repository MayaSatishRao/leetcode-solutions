// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static long minSum(int arr[], int n)
    {
        // Your code goes here
        Arrays.sort(arr);
        String res="";
        int carry=0;
        for(int i=n-1;i>=0;i-=2){
            int a = carry+arr[i];
            if(i-1>=0)
            a+=arr[i-1];
            res+=(char)((a%10)+48);
            carry=a/10;
            
        }
        if(carry==1)
        res+="1";
        
        StringBuilder st = new StringBuilder(res);
        res = st.reverse().toString();
        return Long.parseLong(res);
    }
}