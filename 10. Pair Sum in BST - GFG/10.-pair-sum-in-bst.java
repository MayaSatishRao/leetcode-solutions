// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class PairSum {
    static Node insert(Node node, int data) {
        if (node == null) return new Node(data);

        if (node.data > data) node.left = insert(node.left, data);

        if (node.data < data) node.right = insert(node.right, data);

        return node;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int temp = 0;
            Node root = null;
            for (int i = 0; i < n; i++) {
                temp = sc.nextInt();
                root = insert(root, temp);
            }
            temp = sc.nextInt();
            if (new GFG().findPair(root, temp) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class GFG 
{
    //Function to check if any pair exists in BST
    //whose sum is equal to given value.
   /* static boolean search(Node root, int key){
        while(root!=null){
            if(root.data==key)
            return true;
            if(root.data<key)
            root=root.right;
            else
            root=root.left;
        }
        
        return false;
    }
    
    static boolean find(Node root, Node curr, int X){
        if(curr==null)
        return false;
        
        boolean b = false;
          if(2*curr.data!=X)
          b = search(root,X-curr.data);
          
          //System.out.println(X-curr.data+" "+b);
          return b|| find(root,curr.left,X) || find(root,curr.right,X);
    }*/
    
    static void inorder(Node root, ArrayList<Integer> arr){
        if(root!=null){
            inorder(root.left,arr);
            arr.add(root.data);
            inorder(root.right,arr);
        }
    }
    static boolean findPair(Node root, int X) 
    {
        // Your code
        ArrayList<Integer> arr = new ArrayList<Integer>();
        inorder(root,arr);
        
        int i=0,j=arr.size()-1;
        while(i<j){
            int sum = arr.get(i)+arr.get(j);
            if(sum==X)
            return true;
            if(sum<X)
            i++;
            else
            j--;
        }
        
        return false;
    }
}
