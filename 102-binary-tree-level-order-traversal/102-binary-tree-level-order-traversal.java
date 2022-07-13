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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qt = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root==null)
            return res;
        
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> arr = new ArrayList<>();
           while(!q.isEmpty()){
              TreeNode a = q.remove();
              qt.add(a);
              arr.add(a.val);
           }
            while(!qt.isEmpty()){
                TreeNode b = qt.remove();
                if(b.left!=null)
                    q.add(b.left);
                if(b.right!=null)
                    q.add(b.right);
            }
            res.add(arr);
               
        }
        
        return res;
    }
}