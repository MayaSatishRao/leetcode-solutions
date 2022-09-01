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
    
    public int goodNode(TreeNode root,int minValue){
        if(root==null)
            return 0;
        int ans=1;
        if(root.val<minValue)
            ans=0;
        int a = goodNode(root.left,Math.max(minValue,root.val));
        int b = goodNode(root.right,Math.max(minValue,root.val));
        return ans+a+b;
    }
    public int goodNodes(TreeNode root) {
        return goodNode(root,Integer.MIN_VALUE);
    }
}