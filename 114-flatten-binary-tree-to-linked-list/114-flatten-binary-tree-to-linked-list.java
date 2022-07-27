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
    
   /* public TreeNode func(TreeNode root){
        if(root==null)
            return null;
        TreeNode l = func(root.left);
        TreeNode r = func(root.right);
        
        if(l==null){
            root.right = r;
            root.left=null;
            return root;
        }else if(r==null){
            root.left=null;
            root.right=l;
            return root;
        }
        
        root.left=null;
        root.right = l;
        l.right = 
    }*/
    public void flatten(TreeNode root) {
      /*  if(root==null)
            return ;
        TreeNode curr = root;
        
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr)
                    pred=pred.right;
                pred.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }*/
        if(root==null)
            return ;
        flatten(root.left);
        flatten(root.right);
        if(root.left==null)
            return ;
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left=null;
        if(root.right!=null){
            TreeNode t = root.right;
            while(t.right!=null)
                t=t.right;
            t.right=temp;
        }
        
        
    }
}