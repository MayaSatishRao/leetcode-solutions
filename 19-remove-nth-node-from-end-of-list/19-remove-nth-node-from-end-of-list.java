/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==1 && head.next==null)
            return null;
        if(n==1){
            ListNode prev = null;
            ListNode last = head;
            while(last.next!=null){
                prev=last;
                last=last.next;
            }
            prev.next=null;
            return head;
        }else{
            ListNode a = head;
            for(int i=0;i<n;i++)
                a=a.next;
            ListNode b= head;
            while(a!=null){
                a=a.next;
                b=b.next;
            }
            
            ListNode ne = b.next;
            b.val = ne.val;
            b.next = ne.next;
            
            return head;
        }
    }
}