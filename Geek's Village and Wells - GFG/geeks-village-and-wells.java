//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int[][] res = new int[n][m];
        
        for(int i=0;i<n;i++)
          Arrays.fill(res[i],Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='W')
                    q.add(new int[]{i,j,0});
            }
        }
        
        int[][] diff = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0],co=curr[1],dist=curr[2];
            
            for(int i=0;i<diff.length;i++){
                int row = r+diff[i][0],col=co+diff[i][1];
                if(row<n && row>=0 && col<m && col>=0 && c[row][col]!='N'){
                    if(res[row][col]>1+dist){
                        res[row][col]=1+dist;
                        q.add(new int[]{row,col,1+dist});
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='N' || c[i][j]=='.' || c[i][j]=='W')
                  res[i][j]=0;
                else{
                    if(res[i][j]==Integer.MAX_VALUE)
                        res[i][j]=-1;
                     if(res[i][j]!=-1)
                        res[i][j]*=2;
                }
            }
        }
        
        return res;
        
    }
}