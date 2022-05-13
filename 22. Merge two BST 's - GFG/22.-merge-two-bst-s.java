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
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java


/*
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
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public int inorder(Node root, ArrayList<Integer> arr){
        if(root!=null){
            int a = inorder(root.left,arr);
            arr.add(root.data);
            int b = inorder(root.right,arr);
            return a+b+1;
        }
        return 0;
    }
    
    public ArrayList<Integer> sort(ArrayList<Integer> arr,int mid){
        int[] left = new int[mid];
        int[] right = new int[arr.size()-mid];
        
        
        for(int i=0;i<left.length;i++)
        left[i]=arr.get(i);
        
        for(int i=0;i<right.length;i++)
        right[i]=arr.get(mid+i);
        
       /* System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));*/
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i=0, j=0;
        
        while(i<left.length && j<right.length){
            if(left[i]<right[j])
            res.add(left[i++]);
            else
            res.add(right[j++]);
        }
        
        while(i<left.length){
            res.add(left[i++]);
        }
        
        while(j<right.length){
            res.add(right[j++]);
        }
        
        return res;
    }
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        int a = inorder(root1,arr);
        inorder(root2,arr);
        
        return sort(arr,a);
        
    }
}
