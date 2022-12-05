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
    
    public int countNodes(ListNode head){
        int count=0;
        ListNode  p= head;
        while(p!=null){
            count++;
            p=p.next;
        }
        return count;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       
        return slow;
    }
}