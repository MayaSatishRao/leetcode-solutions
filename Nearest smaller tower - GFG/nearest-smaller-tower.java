//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		Stack<Integer> stk = new Stack<>();
		int[] left = new int[arr.length];
		left[0]=-1;
		stk.push(0);
		
		for(int i=1;i<arr.length;i++){
		    while(!stk.isEmpty() && arr[stk.peek()]>=arr[i])
		      stk.pop();
		    if(stk.isEmpty())
		      left[i]=-1;
		    else
		      left[i]=stk.peek();
		    stk.push(i);
		}
		
		stk = new Stack<>();
		stk.push(arr.length-1);
		int[] right = new int[arr.length];
		right[arr.length-1]=-1;
		
		for(int i=arr.length-2;i>=0;i--){
		    while(!stk.isEmpty() && arr[stk.peek()]>=arr[i])
		      stk.pop();
		    if(stk.isEmpty())
		      right[i]=-1;
		    else
		      right[i]=stk.peek();
		    stk.push(i);
		}
		
		int[] res = new int[arr.length];
		for(int i=0;i<res.length;i++){
		    int dist1 = (left[i]==-1)?Integer.MAX_VALUE:i-left[i];
		    int dist2 = (right[i]==-1)?Integer.MAX_VALUE:right[i]-i;
		    
		    if(dist1==Integer.MAX_VALUE && dist2==Integer.MAX_VALUE)
		      res[i]=-1;
		    else if(dist1<dist2){
		        res[i]=left[i];
		    }else if(dist1==dist2){
		        if(arr[left[i]]<=arr[right[i]])
		          res[i]=left[i];
		        else
		          res[i]=right[i];
		    }else
		      res[i]=right[i];
		      
		}
		
		return res;
	}
}