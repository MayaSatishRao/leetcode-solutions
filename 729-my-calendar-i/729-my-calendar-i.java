


class MyCalendar {

    TreeMap<Integer,Integer> tm;
    public MyCalendar() {
        tm= new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
      /*  boolean cannot = false;
        for(Map.Entry<Integer,Integer> et: tm.entrySet()){
             int prevStart = et.getKey();
             int prevEnd = et.getValue();
            
             if(!(end<=prevStart || start>=prevEnd)){
                 cannot=true;
                 break;
             }
        }
        if(cannot)
            return false;
        tm.put(start,end);
        return true;*/
        
        if(tm.floorEntry(start)!=null && start<tm.floorEntry(start).getValue())
            return false;
        if(tm.ceilingEntry(start)!=null && end>tm.ceilingEntry(start).getKey())
            return false;
        tm.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */