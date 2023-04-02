//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        // Code Here.
        int n = arr.length, m=arr[0].length;
        boolean[][] visit = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x,start_y});
        visit[start_x][start_y] = true;
        
        
        int[][] diff = {{-2,1},{-2,-1},{-1,-2},{-1,2},{2,-1},{2,1},{1,-2},{1,2}};
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(arr[start_x][start_y]);
        
        while(!q.isEmpty()){
            int a = q.size();
            int s=0;
            for(int l=0;l<a;l++){
                int[] p = q.poll();

                
                for(int i=0;i<diff.length;i++){
                    int r = p[0]+diff[i][0],c = p[1]+diff[i][1];
                    if(r>=0 && r<n && c>=0 && c<m && !visit[r][c]){
                        
                              visit[r][c] = true;
                              q.add(new int[]{r,c});
                              s+=arr[r][c];
                    }
                }
                //System.out.println(s);
                
            }
            dp.add(s);
        }
        
        for(int i=dp.size()-1;i>=0;i--){
            int index = i+dp.get(i);
            if(index<dp.size())
              dp.set(i,dp.get(i)+dp.get(index));
        }
        
        int res=0;
        for(int i=1;i<dp.size();i++)
          if(dp.get(i)>dp.get(res))
            res=i;
        
        //System.out.println(dp);
        return res;
    }
}   
