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
    
    public String convert(List<Integer> arr){
        String res="";
        for(int i=0;i<arr.size();i++){
            res+=Integer.toString(arr.get(i));
            if(i!=arr.size()-1)
                res+="->";
        }
        return res;
    }
    
    public  void paths(TreeNode root,List<String> res, List<Integer> arr){
        if(root!=null){
            arr.add(root.val);
            
            if(root.left==null && root.right==null){
                res.add(convert(arr));
                
            }
            
            paths(root.left,res,arr);
            paths(root.right,res,arr);
            
            arr.remove(arr.size()-1);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        List<Integer> arr = new ArrayList<Integer>();
        paths(root,res,arr);
        
        return res;
    }
}