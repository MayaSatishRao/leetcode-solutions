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
    
   /* public boolean search(TreeNode root, TreeNode curr1, int key){
        if(root==null)
            return false;
        TreeNode curr = root;
        while(root!=null){
            if(root.val==key){
                if(curr1!=root)
                    return true;
                else
                    return false;
            }
            if(key<root.val)
                root=root.left;
            else
                root=root.right;
        }
        
        return false;
    }
    
    public boolean find(TreeNode curr, TreeNode root, int k){
        if(root!=null){
            boolean b1 = search(curr,root,k-root.val);
            boolean b2 = find(curr,root.left,k);
            boolean b3 = find(curr,root.right,k);
            
            return b1|| b2||b3;
        }else
            return false;
    }*/
    
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root==null)
            return ;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        
        int i=0,j=arr.size()-1;
        while(i<j){
            int s = arr.get(i)+arr.get(j);
            if(s==k)
                return true;
            if(s>k)
                j--;
            else
                i++;
        }
        
        return false;
    }
}