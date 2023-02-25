//{ Driver Code Starts
// Initial Template for Java

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
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public void dfs(int s, boolean[] visit,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> arr ){
        visit[s] = true;
        arr.add(s);
        for(int next: adj.get(s)){
            if(!visit[next])
              dfs(next,visit,adj,arr);
        }
        
    }
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visit = new boolean[V+1];
        int count=0;
        
          
        for(int i=1;i<=V;i++){
            if(!visit[i]){
                ArrayList<Integer> arr = new  ArrayList<Integer>();
                dfs(i,visit,adj,arr);
                int edges=0,vertices=arr.size();
                for(int j: arr){
                    edges+=adj.get(j).size();
                }
                //System.out.println(vertices+" "+edges);
                if(edges == (vertices*(vertices-1)))
                  count++;
            }
        }
        
        return count;
    }
}