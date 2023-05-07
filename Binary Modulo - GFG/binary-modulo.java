//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			String s = str[0];
			int m = Integer.parseInt(str[1]);
			Solution obj = new Solution();
			System.out.println(obj.modulo(s,m));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int modulo(String s, int m) {
		//Write your code here
		int n = s.length();
		int[] powMod = new int[n];
		powMod[0]=1;
		
		for(int i=1;i<n;i++){
		    powMod[i] = (powMod[i-1]*2)%m;
		}
		
		int res=0;
		int i=0,j=n-1;
		while(j>=0){
		    int a= s.charAt(j)-'0';
		    res = (res+a*powMod[i])%m;
		    i++;
		    j--;
		}
		
		return res;
	}
}