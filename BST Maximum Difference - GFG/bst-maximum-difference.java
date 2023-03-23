//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int minSum(Node root){
        if(root==null)
          return 0;
        if(root.left==null)
          return root.data+minSum(root.right);
        if(root.right==null)
           return root.data+minSum(root.left);
        
        int l = minSum(root.left);
        int r = minSum(root.right);
        return Math.min(l,r)+root.data;
    }
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        int sum=0;
        
          
        while(root!=null){
            if(root.data == target)
              break;
            sum+=root.data;
            if(root.data>target)
              root = root.left;
            
            else
              root = root.right;
        }
        
        if(root==null)
          return -1;
        
        int ms = minSum(root);
        ms-=target;
        //System.out.println(ms);
        //System.out.println(sum+" "+s);
        return sum-ms;
    }
}