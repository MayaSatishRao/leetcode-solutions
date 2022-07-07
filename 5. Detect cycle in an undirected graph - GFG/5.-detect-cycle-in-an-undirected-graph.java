// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visit, int s, int parent){
         visit[s]=true;
         
         for(int i=0;i<adj.get(s).size();i++){
             int next=adj.get(s).get(i);
             
             if(visit[next] && next!=parent)
             return true;
             
             if(!visit[next]){
                 boolean b = dfs(adj,visit,next,s);
                 if(b)
                 return b;
             }
         }
         
         return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visit = new boolean[V];
        boolean ans = false;
        for(int i=0;i<V;i++){
            if(visit[i]==false){
                ans = ans || dfs(adj,visit,i,-1);
            }
            //System.out.println(Arrays.toString(visit));
        }
        
        return ans;
    }
}