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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.add(original);
        s2.push(cloned);
        
        while(!s1.isEmpty()){
            TreeNode p1 = s1.pop();
            TreeNode p2 = s2.pop();
            if(p1==target)
                return p2;
            
            if(p1.right!=null)
                s1.push(p1.right);
            if(p1.left!=null)
                s1.push(p1.left);
            
            if(p2.right!=null)
                s2.push(p2.right);
            if(p2.left!=null)
                s2.push(p2.left);
        }
        
        return null;
    }
}