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
    
    public int inorderSuccessor(TreeNode root ){
        TreeNode p = root.right;
        while(p.left!=null)
            p=p.left;
        
        return p.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key){
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
            int a = inorderSuccessor(root);
            root.val=a;
            root.right = deleteNode(root.right,a);
        }
        else if(root.val>key)
            root.left = deleteNode(root.left,key);
        else
            root.right = deleteNode(root.right,key);
        
        return root;
    }
}