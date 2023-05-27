//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node reverse(Node head){
        
        if(head==null || head.next==null)
          return head;
          
        Node prev=null, curr = head, next = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static Node modifyTheList(Node head)
    {
        if(head==null || head.next==null)
          return head;
        
        Node slow = head, fast = head, slowPrev=null;
        while(fast!=null && fast.next!=null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
            //System.out.println(fast.data+" "+slow.data);
        }
        slowPrev.next = null;
        
        Node halfRev = reverse(slow);
        
       /* while(halfRev!=null){
            System.out.println(halfRev.data+" "+slow.data);
            halfRev = halfRev.next;
        }*/
        Node p = head, q=halfRev;
        while(p!=null){
            int temp = p.data;
            p.data = q.data-p.data;
            q.data = temp;
            
            p=p.next;
            q=q.next;
        }
        
        Node corrHalf = reverse(halfRev);
        slowPrev.next = corrHalf;
        
        return head;
    }
}