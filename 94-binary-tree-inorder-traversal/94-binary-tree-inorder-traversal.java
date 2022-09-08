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
    
    public void inorder(List<Integer> arr, TreeNode root){
        if(root!=null){
            inorder(arr,root.left);
            arr.add(root.val);
            inorder(arr,root.right);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        /*inorder(res,root);
        return res;*/
        if(root==null)
            return arr;
        
        Stack<TreeNode> s= new Stack<>();
        TreeNode a = root;
        
        while(a!=null || !s.isEmpty()){
            
            while(a!=null){
            s.push(a);
            a=a.left;
            }
            
            a=s.pop();
            arr.add(a.val);
            a=a.right;
            
        }
            return arr;
    }
}