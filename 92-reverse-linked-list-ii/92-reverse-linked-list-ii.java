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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int arr[] = new int[right-left+1];
        
            ListNode a = head;
        for(int i=1;i<left;i++)
            a=a.next;
        
        ListNode b = a;
        for(int i=0;i<right-left+1 && a!=null ;i++){
            arr[i]=a.val;
            a=a.next;
        }
        
        for(int i=right-left;i>=0;i--){
            b.val=arr[i];
        b=b.next;
       }
    
       return head;
    }
}