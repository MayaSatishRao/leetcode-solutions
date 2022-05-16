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
    
    public ListNode mergeLists(ListNode a, ListNode b){
        
        if(a==null)
            return b;
        if(b==null)
            return a;
        
        ListNode head = null, tail=null;
        if(a.val<=b.val){
            head=a;
            tail=a;
            a=a.next;
        }else{
            head=b;
            tail=b;
            b=b.next;
        }
        
        while(a!=null && b!=null){
            if(a.val<=b.val){
                tail.next=a;
                tail=a;
                a=a.next;
            }else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        
        if(a!=null){
            tail.next=a;
        }
        
          if(b!=null){
            tail.next=b;
        }
        
       
        return head;
    }
    
    public void display(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1)
            return null;
        if(lists.length==1)
            return lists[0];
        
        ListNode res = mergeLists(lists[0],lists[1]);
        
        for(int i=2;i<lists.length;i++){
            res=mergeLists(res,lists[i]);
            
        }
        
        return res;
    }
}