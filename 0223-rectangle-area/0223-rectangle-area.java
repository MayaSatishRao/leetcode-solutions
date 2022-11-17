class Solution {
    
    public int length(int x1, int x2, int y1, int y2){
        
        if(x1==x2 || y1==y2)
            return 0;
        //System.out.println((y1>=x1 && y1<=x2)+" "+(y2>=x1 && y2<=x2));
        if((y1>=x1 && y1<=x2) && (y2>=x1 && y2<=x2))
            return Math.abs(y2-y1);
        if(y1>=x1 && y1<=x2)
            return Math.abs(x2-y1);
        if(y2>=x1 && y2<=x2)
            return Math.abs(y2-x1);
       
        if((x1>=y1 && x1<=y2) && (x2>=y1 && x2<=y2))
            return Math.abs(x2-x1);
        if(x1>=y1 && x1<=y2)
            return Math.abs(y2-x1);
        if(x2>=y1 && x2<=y2)
            return Math.abs(x2-y1);
        return 0;
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
         int cl = length(ax1,ax2,bx1,bx2);
        int cw = length(ay1,ay2,by1,by2);
        
        int l1= Math.abs(ax2-ax1);
        int l2 = Math.abs(bx2-bx1);
        int w1 = Math.abs(ay2-ay1);
        int w2 = Math.abs(by2-by1);
        
        return (l1*w1)+(l2*w2)-(cl*cw);
    }
}