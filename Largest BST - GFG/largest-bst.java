// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Values{
    int max;
    int min;
    int size;
    boolean isBST;
    
    public Values(int a, int b, int c, boolean d){
        max=a;
        min=b;
        size=c;
        isBST=d;
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    
    
    static Values helper(Node root){
        if(root==null){
            return new Values(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        }
       if(root.left==null && root.right==null){
           return new Values(root.data,root.data,1,true);
       }
       
       Values a = helper(root.left);
       Values b = helper(root.right);
       
       if(a.isBST==false || b.isBST==false)
       return new Values(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(a.size,b.size),false);
       
       if(a.max>=root.data || root.data>=b.min)
       return new Values(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(a.size,b.size),false);
       
       int currMax= Math.max(a.max,Math.max(b.max,root.data));
       int currMin= Math.min(a.min,Math.min(b.min,root.data));
       
       return new Values(currMax,currMin,1+a.size+b.size,true);
       
    }
    static int largestBst(Node root)
    {
        // Write your code here
        Values a = helper(root);
        return a.size;
        
        
    }
    
}