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
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int count(String str, char ch){
        int count=0;
        int i=0;
        while(i<str.length()){
            int j=i;
            while(j<str.length() && str.charAt(j)==ch)
              j++;
            if(j==i)
              j++;
            else
              count++;
            i=j;
        }
        return count;
    }
	int minSteps(String str) {
		//Write your code here
		int a=0,b=0;
		for(int i=0;i<str.length();i++){
		    if(str.charAt(i)=='a')
		      a++;
		    else
		      b++;
		}
		
		int ans =  1+count(str,'b');
		
		ans = Math.min(ans,1+count(str,'a'));
		return ans;
	}
}