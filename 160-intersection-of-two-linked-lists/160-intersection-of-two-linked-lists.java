/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public int getLength(ListNode head){
        int res=0;
        ListNode curr = head;
        while(curr!=null){
            res++;
            curr=curr.next;
        }
        return res;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getLength(headA);
        int b = getLength(headB);
        
        ListNode curr1 = headA,curr2=headB;
        if(a>b){
           for(int i=0;i<a-b;i++)
               curr1=curr1.next;
        }else if(a<b){
            for(int i=0;i<b-a;i++)
               curr2=curr2.next;
        }
        
        while(curr1!=null && curr2!=null){
            if(curr1==curr2)
                return curr1;
            
            curr1=curr1.next;
            curr2=curr2.next;
        }

        return null;
    }
}