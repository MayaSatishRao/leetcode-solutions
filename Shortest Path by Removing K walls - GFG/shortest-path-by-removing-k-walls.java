//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Data{
    int r,c,wall,steps;
    Data(int a, int b, int d,int e){
        r=a;
        c=b;
        wall=d;
        steps=e;
    }
}

class Solution {
    
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        boolean[][] visit = new boolean[n][m];
        int[][] obs = new int[n][m];
        Queue<Data> q = new LinkedList<>();
        
        q.add(new Data(0,0,0,0));
        visit[0][0]=true;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
              obs[i][j]=Integer.MAX_VALUE;
        
        int res=-1;
        obs[0][0]=mat[0][0];
        
        while(!q.isEmpty()){
                Data p = q.poll();
                
                if(p.r==n-1 && p.c==m-1)
                    if(res==-1)
                       res=p.steps;
                    else
                       res=Math.min(res,p.steps);
                 
                for(int j=0;j<4;j++){
                    int x = p.r+dir[j][0];
                    int y = p.c+dir[j][1];
                    
                    if(x<0 || y<0 || x>=n || y>=m )
                    continue;
                    
                    if(!visit[x][y]){
                        int ob = mat[x][y]+p.wall;
                        if(ob<=k){
                            obs[x][y]=ob;
                            q.add(new Data(x,y,ob,p.steps+1));
                        }
                        visit[x][y]=true;
                    }else{
                        int ob = mat[x][y]+p.wall;
                        if(ob<obs[x][y]){
                            obs[x][y]=ob;
                            q.add(new Data(x,y,ob,p.steps+1));
                        }
                    }
                }
            //System.out.println(p.r+" "+p.c);
        }
        
        return res;
    }
};