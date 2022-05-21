// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
        	int N = Integer.parseInt(br.readLine()); 
        	int[] Arr = new int[N];
        	String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        	for(int i=0; i<N; i++)
        	{
        		Arr[i] = Integer.parseInt(strs[i]); 
        	}
        	

            Solution ob = new Solution();
			int[] ans = ob.farNumber(N,Arr);
  
            for(int i=0; i<ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int[] farNumber(int N, int arr[])
	{    
	    
        int[] res = new int[N];
        res[N-1]=arr[N-1];
        
        int min=arr[N-1];
        for(int i=N-2;i>=0;i--){
            if(arr[i]<min){
                res[i]=arr[i];
                min=arr[i];
            }else
            res[i]=min;
            
        }
        
        int[] ans = new int[N];
        for(int i=0;i<N;i++){
            int a = -1;
            int low = i+1, high=N-1;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(res[mid]<arr[i]){
                    a=mid;
                    low=mid+1;
                }else
                  high=mid-1;
            }
            ans[i]=a;
        }
        
        
        return ans;
	}
} 