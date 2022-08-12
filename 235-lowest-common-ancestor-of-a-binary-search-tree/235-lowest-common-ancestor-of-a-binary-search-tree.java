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
    
    public boolean path(TreeNode root, ArrayList<TreeNode> arr, TreeNode p){
        if(root==null)
            return false;
        arr.add(root);
        if(root==p)
            return true;
        if(path(root.left,arr,p)||path(root.right,arr,p))
            return true;
        arr.remove(arr.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> p2 = new ArrayList<TreeNode>();
        
        boolean b1 = path(root,p1,p);
        boolean b2 = path(root,p2,q);
        
        if(!b1 || !b2)
            return null;
        int i=1;
        for(;i<p1.size() && i<p2.size();i++)
            if(p1.get(i) != p2.get(i))
                return p1.get(i-1);
        
        return p1.get(i-1);
    }
}