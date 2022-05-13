/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty()){
            int a= q.size();
            Node[] arr= new Node[a];
            
            for(int i=0;i<a;i++){
                arr[i]=q.poll();
                
                if(arr[i].left!=null)
                    q.add(arr[i].left);
                if(arr[i].right!=null)
                    q.add(arr[i].right);
            }
            
            for(int i=0;i<a-1;i++)
                arr[i].next = arr[i+1];
        }
        
        return root;
    }
}