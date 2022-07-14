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
    
  /*  public boolean isLeft(int[] preorder, int[] inorder, int i, int p){
        int ii=0,pi=0;
        for(int j=0;j<inorder.length;j++){
            if(inorder[j]==i){
               ii=j;
            }
            if(inorder[j]==p){
                pi=j;
            }
        }
    
        
        if(ii<pi)
            return true;
        else
            return false;
        
    }*/
    public int preIndex=0;
    public TreeNode cTree(int[] pre, int[] in, int is, int ie){
        if(is>ie)
            return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        int j=0;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.val){
                j=i;
                break;
            }
        }
        root.left = cTree(pre,in,is,j-1);
        root.right= cTree(pre,in,j+1,ie);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
       return cTree(preorder,inorder,0,preorder.length-1);
    }
}