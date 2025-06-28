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
class  Operation{
        int step=1;
        public void oddOREven(ListNode head,ListNode tail,int len){
        ListNode temp=null,curr=head;

        while(step<len){
            temp=curr.next;
            curr.next=curr.next.next;
            temp.next=null;
            tail.next=temp;
            tail=temp;
            step+=2;
            curr=curr.next;
        }

        }

    }




class Solution {
    public ListNode oddEvenList(ListNode head) {
        Operation op=new Operation();
        ListNode curr=head,tail=null;
        int len=1;
        
        while(curr!=null &&curr.next!=null){
            len++;
            curr=curr.next;
        }if(len<=2){
            return head;
        }
        tail=curr;
        op.oddOREven(head,tail,len);


        return head;

    }
}