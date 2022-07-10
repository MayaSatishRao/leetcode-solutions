class Solution {
    
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visit, boolean[] rs, int s){
        visit[s]=true;
        rs[s]=true;
        
        for(int i=0;i<adj.get(s).size();i++){
            int next = adj.get(s).get(i);
            if(!visit[next] && detectCycle(adj,visit,rs,next))
                return true;
            if(rs[next])
                return true;
        }
        
        rs[s]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            
            adj.get(start).add(end);
        }
        
        boolean[] visit = new boolean[numCourses];
        boolean[] rs = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visit[i] && detectCycle(adj,visit,rs,i))
                return false;
        }
        
        return true;
    }
}