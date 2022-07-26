/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        
        if(root.val==p.val || root.val==q.val)
            return root;
        
        TreeNode lp = lowestCommonAncestor(root.left,p,q);
        TreeNode rp = lowestCommonAncestor(root.right,p,q);
        
        if(lp!=null && rp!=null){
            return root;
        }
        if(lp!=null)
            return lp;
        else
            return rp;
    }
}