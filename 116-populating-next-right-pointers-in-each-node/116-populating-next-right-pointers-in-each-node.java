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
    
   
    public Node connect(Node a) {
     /*   if(root==null)
            return null;
        
        Queue<Node > q = new LinkedList<Node>();
        q.add(root);
        
        while(q.size()>0){
            int a = q.size();
            ArrayList<Node> level = new ArrayList<Node>();
            
            for(int i=0;i<a;i++){
                Node b = q.poll();
                level.add(b);
                if(b.left!=null)
                    q.add(b.left);
                if(b.right!=null)
                    q.add(b.right);
            }
            
            for(int i=0;i<level.size()-1;i++)
                level.get(i).next=level.get(i+1);
            
            if(level.size()>0)
            level.get(level.size()-1).next=null;
            
            
        }
        
        return root;*/
        Node root=a;
        if(root==null)
            return root;
       
        while(root!=null && root.left!=null){
            Node n = root;
            
            while(true){
                n.left.next=n.right;
                if(n.next==null)
                    break;
                
                n.right.next = n.next.left;
                n=n.next;
            }
            root=root.left;
        }
        return a;
    }
}