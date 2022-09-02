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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        
        if(root==null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(q.size()!=0){
            int a = q.size();
            long sum=0;
            for(int i=0;i<a;i++){
                TreeNode p = q.poll();
                sum+=p.val;
                
                if(p.left!=null)
                    q.add(p.left);
                if(p.right!=null)
                    q.add(p.right);
            }
            
            double avg = (double)(sum)/(double)a;
            res.add(avg);
        }
        
        return res;
    }
}