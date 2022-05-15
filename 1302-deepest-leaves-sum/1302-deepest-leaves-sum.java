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
    
    
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null)
            return 0;
        
        q.add(root);
        int sum=0;
        while(!q.isEmpty()){
            int a = q.size();
            sum=0;
            for(int i=0;i<a;i++){
                TreeNode p = q.poll();
                sum+=p.val;
                
                if(p.left!=null)
                    q.add(p.left);
                if(p.right!=null)
                    q.add(p.right);
            }
        }
        
        return sum;
         
    }
}