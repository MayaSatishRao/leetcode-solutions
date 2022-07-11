/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(q.size()!=0){
            int a =q.size();
            for(int i=0;i<a;i++){
                TreeNode b = q.poll();
                if(i==a-1)
                    res.add(b.val);
                if(b.left!=null)
                    q.offer(b.left);
                if(b.right!=null)
                    q.offer(b.right);
            }
        }
        
        return res;
    }
}