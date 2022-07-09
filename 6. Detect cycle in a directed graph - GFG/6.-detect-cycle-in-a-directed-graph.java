// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visit, boolean[] rs){
        //System.out.println("fhfh "+s);
        visit[s]=true;
        rs[s]=true;
        for(int i=0;i<adj.get(s).size();i++){
            int next = adj.get(s).get(i);
            if(!visit[next] && dfs(adj,next,visit,rs))
            return true;
            if(rs[next])
            return true;
        }
         rs[s]=false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visit = new boolean[V];
        boolean[] rs = new boolean[V];
        
        for(int i=0;i<V;i++){
             if(!visit[i] && dfs(adj,i,visit,rs))
             return true;
        }
        
        return false;
    }
}