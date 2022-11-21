class Pair{
    int x, y,step;
    Pair(int a, int b, int c){
        x=a;
        y=b;
        step=c;
    }
}
class Solution {
    
    public boolean isExit(Pair ex, Pair ent, int n, int m){
        //System.out.println(ex.x+" "+ex.y+" "+ent.x+" "+ent.y);
        if((ex.x==0 || ex.y==0 || ex.x==n || ex.y==m) && !(ex.x==ent.x && ex.y==ent.y) )
            return true;
        return false;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> q = new LinkedList<>();
        int n = maze.length, m=maze[0].length;
        boolean[][] visit = new boolean[n][m];
        Pair ent = new Pair(entrance[0],entrance[1],0);
        q.add(ent);
        visit[entrance[0]][entrance[1]]=true;
        
        int res=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(isExit(p,ent,n-1,m-1))
                 res=Math.min(res,p.step);
            if(p.x-1>=0 && maze[p.x-1][p.y]=='.' && !visit[p.x-1][p.y]){
                q.add(new Pair(p.x-1,p.y,p.step+1));
                visit[p.x-1][p.y]=true;
            }          
            if(p.y-1>=0 && maze[p.x][p.y-1]=='.' && !visit[p.x][p.y-1]){
                q.add(new Pair(p.x,p.y-1,p.step+1));
                visit[p.x][p.y-1]=true;
            }
            if(p.x+1<n && maze[p.x+1][p.y]=='.' && !visit[p.x+1][p.y]){
                q.add(new Pair(p.x+1,p.y,p.step+1));
                visit[p.x+1][p.y]=true;
            }
            if(p.y+1<m && maze[p.x][p.y+1]=='.' && !visit[p.x][p.y+1]){
                q.add(new Pair(p.x,p.y+1,p.step+1));
                visit[p.x][p.y+1]=true;
            }
            //System.out.println(res);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}