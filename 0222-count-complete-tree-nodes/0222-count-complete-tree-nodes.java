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
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int l=0;
        TreeNode a = root;
        while(a!=null){
            l++;
            a=a.left;
        }
        
        int r=0;
        a=root;
        while(a!=null){
            r++;
            a=a.right;
        }
        
        if(l==r)
            return (int)Math.pow(2,l)-1;
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}