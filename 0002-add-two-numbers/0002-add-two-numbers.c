/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* getNode(){
    struct ListNode* p = (struct ListNode*)malloc(sizeof(struct ListNode));
    p->next=NULL;
    return p;
}

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
      struct ListNode* res=NULL;
      struct ListNode* p=l1;
      struct ListNode* q=l2;
    
     int carry=0;
     while(p!=NULL && q!=NULL){
         struct ListNode* s = getNode();
         
          int sum=carry+p->val+q->val;
          s->val=sum%10;
          carry = sum/10;
          
          if(res==NULL)
              res=s;
         else{
             struct ListNode* r = res;
             while(r->next!=NULL)
                 r=r->next;
             r->next=s;
         }
         
         p=p->next;
         q=q->next;
     }
    
     while(p!=NULL){
          struct ListNode* s = getNode();
         
         int sum=carry+p->val;
          s->val=sum%10;
          carry = sum/10;
         
          struct ListNode* r = res;
             while(r->next!=NULL)
                 r=r->next;
             r->next=s;
        
         p=p->next;
     }
      
     while(q!=NULL){
          struct ListNode* s = getNode();
         
         int sum=carry+q->val;
          s->val=sum%10;
          carry = sum/10;
         
          struct ListNode* r = res;
             while(r->next!=NULL)
                 r=r->next;
             r->next=s;
        
         q=q->next;
     }
    
     if(carry==1){
         struct ListNode* s = getNode();
         s->val=1;
         struct ListNode* r = res;
             while(r->next!=NULL)
                 r=r->next;
             r->next=s;
     }
    
    return res;
}