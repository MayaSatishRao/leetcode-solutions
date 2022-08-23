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
    
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        
        // finding the middle node
        ListNode mid = head;
        ListNode a = head;
        while(a.next!=null && a.next.next!=null){
            mid=mid.next;
            a=a.next.next;
        }
        
        // reversing the other half of linked list
        ListNode c = reverse(mid.next);
        while(c!=null){
            if(head.val!=c.val)
                return false;
            head=head.next;
            c=c.next;
        }
        
        return true;
    }
}