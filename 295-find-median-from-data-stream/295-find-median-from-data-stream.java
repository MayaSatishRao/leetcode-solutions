class MedianFinder {

    
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(max.size()==0){
            max.add(num);
            return ;
        }
        if(min.size()==0){
            if(num>max.peek())
                min.add(num);
            else{
                min.add(max.poll());
                max.add(num);
            }
            return ;
                
        }
            
        if(min.size()==max.size()){
            if(num>min.peek()){
                max.add(min.poll());
                min.add(num);
            }else{
                max.add(num);
            }
                
        }else{
            
            if(num>max.peek())
                min.add(num);
            else{
                min.add(max.poll());
                max.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            return ((double)max.peek()+(double)min.peek())/(double)2;
        }
        return (double)max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */