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
    
    public int leftMax(TreeNode root){
        TreeNode curr = root.left;
        while(curr.right!=null)
            curr=curr.right;
        return curr.val; 
    }
    
    public int rightMin(TreeNode root){
        TreeNode curr = root.right;
        while(curr.left!=null)
            curr=curr.left;
        return curr.val; 
    }
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return Integer.MAX_VALUE;
        int diff1 = root.left!=null?Math.abs(root.val-leftMax(root)):Integer.MAX_VALUE;
        int diff2 = root.right!=null?Math.abs(root.val-rightMin(root)):Integer.MAX_VALUE;
        
        diff1 = Math.min(diff1,diff2);
        
        int a = getMinimumDifference(root.left);
        int b = getMinimumDifference(root.right);
        
        //System.out.println(a+" "+b);
        
        return Math.min(diff1, Math.min(a,b));
    }
}