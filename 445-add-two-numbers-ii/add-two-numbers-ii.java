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
    ListNode head=null;
    ListNode tail=null;

    public void add(int n){
        ListNode curr=new ListNode(n);
        if(head==null){
            head=curr;
            return;
        }
        if(tail==null){
            tail=curr;
            head.next=curr;
            return;
        }
        tail.next=curr;
        tail=curr;


    }

    public void rev(ListNode curr){
        ListNode next=null,prev=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode L1=null,L2=null;
        ListNode curr=l1;

        while(curr.next!=null){
            curr=curr.next;
        }

        rev(l1);
        L1=curr;
        
        curr=l2;
        while(curr.next!=null){
            curr=curr.next;
        }

        rev(l2);
        L2=curr;


        
        ListNode curr1=null,curr2=null;

        curr1=L1;
        curr2=L2;

        int carry=0;



        while(curr1!=null && curr2!=null){
            int sum=curr1.val+curr2.val;
            sum+=carry;
            if(sum>=10){
                carry=sum/10;
                sum=sum%10;
            }else{
                carry=0;
            }
            
            add(sum);

            curr1=curr1.next;
            curr2=curr2.next;
            
        }


        
        while(curr1!=null){
            int sum=curr1.val+carry;
            if(sum>=10){
                carry=sum/10;
                sum%=10;

            }else{
                carry=0;
            }
            add(sum);
            curr1=curr1.next;
        }
        
        
        while(curr2!=null){
            int sum=curr2.val+carry;
            if(sum>=10){
                carry=sum/10;
                sum%=10;
            }else{
                carry=0;
            }
            add(sum);
            curr2=curr2.next;
        }


        if(carry!=0){
            add(carry);
        }

        
         if(tail==null){
            return head;
        }

        rev(head);


        return tail;

        
    }
}