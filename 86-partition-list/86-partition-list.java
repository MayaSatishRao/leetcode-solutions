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
    
    public ListNode partition(ListNode head, int x) {
        ListNode less = null,next1=null;
        ListNode great=null,next2=null;
        
        while(head!=null){
            if(head.val<x){
                if(less==null){
                    less=head;
                    next1=head;
                }else{
                    next1.next=head;
                    next1=head;
                }
            }else{
                if(great==null){
                    great=head;
                    next2=head;
                }else{
                    next2.next=head;
                    next2=head;
                }
            }
            head=head.next;
        }
        
        if(less==null && great==null)
            return null;
        if(less==null){
            next2.next=null;
           return great; 
        }
            
        if(great==null){
            next1.next=null;
            return less;
        }
            
        
        next1.next=null;
        next2.next=null;
        
        next1.next=great;
        
        return less;
    }
}