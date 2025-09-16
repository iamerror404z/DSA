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

    public ListNode Head=null;
    ListNode tail=null;

    public void adder(int n){
        ListNode curr=new ListNode(n);
        if(Head==null){
            Head=curr;
            return;
        }
        if(tail==null){
            tail=curr;
            Head.next=tail;
            return;
        }
        tail.next=curr;
        tail=curr;

    }

    public ListNode rev(ListNode curr){
        ListNode next=null,prev=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;

    }

    public ListNode removeNodes(ListNode head) {
        int len=0;
        ListNode curr=head;

        while(curr!=null){
            curr=curr.next;
            len++;
        }

        ListNode temp=rev(head);

        int max=temp.val;

        while(temp!=null){
            if(temp.val>=max){
                adder(temp.val);
            }
            max=Math.max(max,temp.val);
            temp=temp.next;
        }

        ListNode ls=rev(Head);

        return ls;
    }
}