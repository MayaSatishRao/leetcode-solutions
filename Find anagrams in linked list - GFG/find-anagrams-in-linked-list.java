//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        int[] str = new int[26];
        for(int i=0;i<s.length();i++)
          str[s.charAt(i)-'a']++;
          
        ArrayList<Node> arr = new ArrayList<>();
        int[] freq = new int[26];
        
        Node p=head,start=head;
        while(p!=null){
            char ch = p.data;
             
            freq[ch-'a']++;
            
            if(str[ch-'a']==0 && freq[ch-'a']!=0){
                start=p.next;
                p=p.next;
                freq = new int[26];
                continue;
            }
            if(str[ch-'a']<freq[ch-'a']){
                while(str[ch-'a']!=freq[ch-'a']){
                    freq[start.data-'a']--;
                    start=start.next;
                }
                p=p.next;
                continue;
            }
            
            boolean equal = true;
             for(int i=0;i<26;i++){
                // char not present in string or freqency of character is less
                if(str[i]!=freq[i])
                  equal=false;
            }
            
            if(equal){
                Node q = p.next;
                p.next = null;
                arr.add(start);
                p=q;
                start=q;
                freq = new int[26];
            }else
            p=p.next;
        }
        
        return arr;
    }
}