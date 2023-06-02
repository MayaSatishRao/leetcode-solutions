//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete{
    
    public static ArrayList<Integer> prime = new ArrayList<Integer>();
    public static void precompute () {
        //Complete the function
        boolean[] num = new boolean[1000001];
        for(int i=2;i<num.length;i++){
            if(!num[i]){
                prime.add(i);
                for(int j=i;j<num.length;j+=i)
                  num[j] = true;
            }
        }
    }
    
   
    
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visit, int s, int[] ans){
        visit[s]=true;
        ans[0]++;
        
        for(int next: graph.get(s)){
            if(!visit[next]){
                dfs(graph,visit,next,ans);
            }
        }
    }
    // Function for finding maximum and value pair
    public static int helpSanta (int n, int m, int g[][]) {
        //Complete the function
        if(m==0)
          return -1;
          
        
        //getPrimes();
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
          graph.add(new ArrayList<Integer>());
        
        for(int i=0;i<m;i++){
            int s = g[i][0]-1, e=g[i][1]-1;
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        boolean[] visit = new boolean[n];
        int res=0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                int[] ans = new int[1];
                dfs(graph,visit,i,ans);
                res = Math.max(res,ans[0]);
            }
        }
        
       return prime.get(res-1);
        
        
    }
    
    
}