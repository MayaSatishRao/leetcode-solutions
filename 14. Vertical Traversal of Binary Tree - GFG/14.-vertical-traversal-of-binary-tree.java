// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}
// } Driver Code Ends


//User function Template for Java
class ListNode{
    int data;
    int row;
    int col;
    ListNode next;
    
    public ListNode(int d, int r, int c){
        data=d;
        row=r;
        col=c;
    }
}

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    
   /*  static void sortedInsert(ListNode l, Node root, int r, int c){
         if(l==null){
             l= new ListNode(root.data,r,c);
             return l;
         }else{
             ListNode prev = null, curr=l;
             while(curr!=null && curr.r<=r && curr.c<c){
                 prev=curr;
                 curr=curr.next;
             }
             ListNode p = new ListNode(root.data,r,c);
             
             if(prev=null){
                 p.next=l;
                 return p;
             }else{
                 prev.next=p;
                 p.next=curr;
             }
         }
     }
     static void vertical(TreeNode root,int row,int col, arr){
        if(root!=null){
            
            sortedInsert(arr,root,row,col);
            //System.out.println(root.val);
            vertical(root.left,curr-1,arr,hm);
            vertical(root.right,curr+1,arr,hm);
        }
    }*/
    
    
   /* static void vertical(Node root,int curr,ArrayList<Integer> arr, HashMap<Integer, ArrayList<Integer>> hm){
        if(root!=null){
            if(!arr.contains(curr))
            arr.add(curr);
            if(hm.get(curr)==null){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(root.data);
                hm.put(curr,temp);
            }else{
                ArrayList<Integer> temp = hm.get(curr);
                hm.remove(curr);
                temp.add(root.data);
                hm.put(curr,temp);
            }
            //System.out.println(root.val);
            vertical(root.left,curr-1,arr,hm);
            vertical(root.right,curr+1,arr,hm);
        }
    }*/
    
    static int countNodes(Node root){
        if(root==null)
        return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    static void inorderTraversal(Node root, int curr,int n){
        if(root!=null){
            inorderTraversal(root.left,curr-1,n);
            root.data = (root.data*n)+curr;
            inorderTraversal(root.right,curr+1,n);
        }
    }
    
    static void levelTraversal(Node root,int n,ArrayList<Integer> arr, HashMap<Integer, ArrayList<Integer>> hm){
        Queue<Node> q = new LinkedList<Node>();
        if(root==null)
        return ;
        q.add(root);
        
        while(!q.isEmpty()){
            int a = q.size();
            
            for(int i=0;i<a;i++){
                Node p =q.poll();
                int curr= p.data%(n);
                
                if(!arr.contains(curr))
                arr.add(curr);
                if(hm.get(curr)==null){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(p.data/(n));
                hm.put(curr,temp);
                }else{
                ArrayList<Integer> temp = hm.get(curr);
                hm.remove(curr);
                temp.add(p.data/(n));
                hm.put(curr,temp);
                }
                
                
                if(p.left!=null)
                q.add(p.left);
                if(p.right!=null)
                q.add(p.right);
            }
        }
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null)
        return res;
        int n = countNodes(root);
        inorderTraversal(root,n,2*n);
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        
        
        levelTraversal(root,2*n,arr,hm);
        Collections.sort(arr);
        
        for(int i=0;i<arr.size();i++){
            ArrayList<Integer> temp = hm.get(arr.get(i));
            //System.out.println(arr.get(i)+" "+temp);
            for(int j=0;j<temp.size();j++)
            res.add(temp.get(j));
        }
        
            
        return res;
    }
}