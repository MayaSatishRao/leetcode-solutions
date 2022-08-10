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
    
    public TreeNode createTree(int[] nums, int low, int high){
        if(low>high || low<0 || high>=nums.length)
            return null;
        if(low==high)
            return new TreeNode(nums[low]);
        int mid = (low+high)/2;
        TreeNode p = new TreeNode(nums[mid]);
        p.left = createTree(nums,low,mid-1);
        p.right = createTree(nums,mid+1,high);
        
        return p;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums,0,nums.length-1);
    }
}