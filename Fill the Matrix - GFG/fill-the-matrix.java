//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		boolean[][] visit = new boolean[N][M];
		visit[x-1][y-1] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[]{x-1,y-1});
		
		int[][] diff = {{-1,0},{1,0},{0,-1},{0,1}};
		int count=0;
		
		while(!q.isEmpty()){
		    
		    int a = q.size();
		    for(int j=0;j<a;j++){
		        
		        int[] p = q.poll();
		        for(int i=0;i<4;i++){
		            int r = p[0]+diff[i][0], c=p[1]+diff[i][1];
		             //System.out.println(r+" "+c);
		            if(r>=0 && r<N && c>=0 && c<M){
		               
		                if(!visit[r][c]){
		                    q.add(new int[]{r,c});
		                    visit[r][c] = true;
		                }
		            }
		        }
		        
		    }
		    
		    count++;
		    
		}
		
		return count-1;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends