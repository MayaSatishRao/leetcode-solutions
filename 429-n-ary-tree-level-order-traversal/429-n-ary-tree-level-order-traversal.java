/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<Node> q = new LinkedList<Node>();
        
        if(root==null)
            return res;
        q.add(root);
        
        while(!q.isEmpty()){
            int a = q.size();
            List<Integer> el = new ArrayList<Integer>();
            for(int j=0;j<a;j++){
                Node p = q.poll();
                el.add(p.val);
                for(int i=0;i<p.children.size();i++){
                    Node ch = p.children.get(i);
                    if(ch!=null)
                        q.add(ch);
                }
            }
            
            res.add(el);
        }
        
        return res;
    }
}