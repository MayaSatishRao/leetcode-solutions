class MyStack {

    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        if(q.size()==0)
            q.add(x);
        else{
            q.add(x);
            int j=q.size()-1;
            for(int i=0;i<j;i++){
                int temp=q.remove();
                q.add(temp);
            }
        }
    }
    
    public int pop() {
        
        return q.remove();
    }
    
    public int top() {
        
        return q.peek();
    }
    
    public boolean empty() {
        if(q.size()==0)
            return true;
        else
            return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */