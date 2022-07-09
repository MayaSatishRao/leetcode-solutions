class Solution {
    
    public void dfs(int[][] adj, boolean[]visit, int s){
        visit[s]=true;
        
        for(int i=0;i<visit.length;i++){
            if(!visit[i] && adj[s][i]==1)
                dfs(adj,visit,i);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            isConnected[i][i]=0;
        }
        
        int count=0;
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
               dfs(isConnected,visit,i);
                count++;
            }
        }
            
         return count;       
    }
}