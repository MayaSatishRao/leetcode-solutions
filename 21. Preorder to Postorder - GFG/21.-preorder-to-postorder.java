// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

class Node { 
	int data; 
	Node left, right; 
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 


class GFG {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = post_order(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    
    
    
    
 // } Driver Code Ends
//User function Template for Java


//Function that constructs BST from its preorder traversal.

public static Node insert(Node root, int key){
    if(root==null)
    return new Node(key);
    
    Node prev = null;
    Node curr = root;
    while(curr!=null){
        prev = curr;
        if(curr.data>key)
        curr=curr.left;
        else
        curr=curr.right;
    }
    
    if(prev.data<key)
    prev.right = new Node(key);
    else
    prev.left = new Node(key);
    
    return root;
}
public static Node post_order(int pre[], int size) 
{
    //Your code here
    Node res= null;
    for(int i=0;i<size;i++)
    res = insert(res,pre[i]);
    
    return res;
} 

// { Driver Code Starts.


public static 	void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static 	void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static 	void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 

}  // } Driver Code Ends