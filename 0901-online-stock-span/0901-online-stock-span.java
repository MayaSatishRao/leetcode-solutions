class StockSpanner {

    ArrayList<Integer> arr;
    public StockSpanner() {
        arr = new ArrayList<Integer>();
    }
    
    public int next(int price) {
        int res=0;
        arr.add(price);
        for(int i=arr.size()-1;i>=0;i--){
            if(arr.get(i)>price)
                break;
            res++;
        }
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */