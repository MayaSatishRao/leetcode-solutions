//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean bfs(char[][] board, String word, int sr, int sc){
        Queue<int[]> q = new LinkedList<>();
        int n = board.length, m=board[0].length;
        boolean[][] visit = new boolean[n][m];
        int[][] diff = {{-1,0},{1,0},{0,-1},{0,1}};
        
        q.add(new int[]{sr,sc});
        visit[sr][sc] = true;
        int index=1;
        //System.out.println(n+" "+m);
        while(!q.isEmpty() && index<word.length()){
            int a = q.size();
            for(int j=0;j<a;j++){
                int[] curr = q.poll();
                boolean found = false;
                int row = curr[0], col = curr[1];
                //System.out.println(row+" "+col);
                for(int i=0;i<diff.length;i++){
                    int r = row+diff[i][0], c=col+diff[i][1];
                    if(r>=0 && c>=0 && r<n && c<m && !visit[r][c] && board[r][c]==word.charAt(index)){
                          found = true;
                          visit[r][c] = true;
                          q.add(new int[]{r,c});
                          
                    }
                }
                if(!found)
                  return false;
            }
            index++;
        }
        
        if(index==word.length())
          return true;
        return false;
    }
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean b = bfs(board,word,i,j);
                    if(b)
                     return true;
                }
                    
            }
        }
        
        return false;
    }
}