/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
   /* public  String a="";
    public void serial(TreeNode root){
        if(root==null){
            a+="null.";
            return ;
        }else{
            a+=Integer.toString(root.val);
            a+=".";
            serial(root.left);
            serial(root.right);
        }
    }*/
    
    public void serializeHelper(TreeNode root, StringBuilder str){
        if(root==null){
            str.append("N,");
            return ;
        }
        str.append(Integer.toString(root.val));
        str.append(",");
        serializeHelper(root.left,str);
        serializeHelper(root.right,str);
    }
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serializeHelper(root,str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    
   /* public TreeNode deserial(String[] arr, int i){
        if(i==arr.length){
            return null;
        }
        String a = arr[i];
        i++;
        System.out.println(a);
        if(a.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(a));
        root.left = deserial(arr,i);
        root.right = deserial(arr,i+1);
        
        return root;
        
    }*/
    
    int index=0;
    public TreeNode deserializeHelper(String[] arr){
        
        if(index>=arr.length || arr[index].equals("N")){
            index++;
            return null;
        }
        
        TreeNode n = new TreeNode(Integer.valueOf(arr[index++]));
        n.left= deserializeHelper(arr);
        n.right= deserializeHelper(arr);
        return n;
    }
    public TreeNode deserialize(String data) {
        String[] arr = data.split("\\,");
        index=0;
        return deserializeHelper(arr);
        
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));