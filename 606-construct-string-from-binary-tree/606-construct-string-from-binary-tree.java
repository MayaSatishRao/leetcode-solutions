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
    public String tree2str(TreeNode root) {
        if(root==null)
            return "";
        String s1 = tree2str(root.left);
        String s2 = tree2str(root.right);
        
        String res=Integer.toString(root.val);
        if(root.left!=null){
            s1="("+s1+")";
            res+=s1;
        }else if(root.left==null && root.right!=null)
            res+="()";
        
        if(s2.length()>0){
            s2="("+s2+")";
            res+=s2;
        }
        
        return res;
    }
}