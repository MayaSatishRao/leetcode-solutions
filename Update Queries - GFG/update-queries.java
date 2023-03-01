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
			int N = Integer.parseInt(str[0]);
			int Q = Integer.parseInt(str[1]);
			int [][] U = new int[Q][3];
			int i = 0;
			while(i < Q) {
				str = br.readLine().trim().split(" ");
				U[i][0] = Integer.parseInt(str[0]);
				U[i][1] = Integer.parseInt(str[1]);
				U[i][2] = Integer.parseInt(str[2]);
				i++;
			}
			Solution obj = new Solution();
			int [] arr = obj.updateQuery(N, Q, U);
			for(int j: arr) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] updateQuery(int N, int Q, int [][]U){
        //Write your code here
        int[][] arr = new int[N+1][32];
        for(int i=0;i<Q;i++){
            int l = U[i][0], r=U[i][1], x = U[i][2];
            int pos = 0;
            
            while(x>0){
                if((x&1)==1){
                    arr[l-1][pos]++;
                    arr[r][pos]--;
                }
                x/=2;
                pos++;
            }
            
        }
        
      /*  for(int i=0;i<N+1;i++)
          System.out.println(Arrays.toString(arr[i]));*/
          
        int[] res = new int[N];
        for(int i=0;i<32;i++){
            if(arr[0][i]>=1)
              res[0]+=(int)Math.pow(2,i);
        }
        
        for(int i=1;i<N;i++){
            for(int j=0;j<32;j++){
                arr[i][j]+=arr[i-1][j];
                if(arr[i][j]>=1)
                  res[i]+=(int)Math.pow(2,j);
            }
        }
        
        return res;
    }
}