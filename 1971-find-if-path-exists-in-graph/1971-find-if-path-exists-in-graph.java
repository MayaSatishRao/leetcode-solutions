class Solution {
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,int s, int d){
        int n = adj.size();
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visit[s]=true;
        
        while(!q.isEmpty()){
            int a = q.poll();
            if(a==d)
                return true;
            visit[a]=true;
            
            for(int i=0;i<adj.get(a).size();i++){
                int next = adj.get(a).get(i);
                if(!visit[next])
                q.add(next);
            }
        }
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b= edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
       /* for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.println(adj[i][j]+" ");
            System.out.println();
        }*/
        
        return bfs(adj,source,destination);
    }
}