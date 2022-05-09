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
    
  /*  public boolean validBST(TreeNode root, int low, int high){
        if(root==null)
            return true;
        boolean a = validBST(root.left,low,root.val-1);
        if(root.val<low || root.val>high)
            return false;
        if(root.val==Integer.MIN_VALUE && root.left!=null)
            return false;
        if(root.val==Integer.MAX_VALUE && root.right!=null)
            return false;
        boolean b = validBST(root.right,root.val+1,high);
        //System.out.println(a+" "+b);
        return a&&b;
    }*/
    
    public long prev = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
       //return validBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        if(root==null)
            return true;
        if(!isValidBST(root.left) || (root.val)<=prev)
            return false;
        prev = root.val;
        return isValidBST(root.right);
    }
}