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
// class Operation{
//     ListNode head=null;
//     ListNode tail=null;

//     public void op(int n){
//         if(head)
//     }
// }


class Solution {
    ListNode Head=null, tail=null;
    public void append(int n){
        ListNode curr=new ListNode(n);
        if(Head==null){
            Head=curr;
            return ;
        }if(tail==null){
                 tail=curr;
                Head.next=tail;
                return ;
        }
        tail.next=curr;
        tail=curr;
        return ;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode left=null,right=null;
        left=head;
        int num=0;
        int step=0;
        while(left!=null){
            step=1;
            num=left.val;
            right=left;
            while(right!=null && right.next!=null && right.next.val==num){
                step++;
                right=right.next;

            }
            if(step==1){
                append(num);
            }
            left=right.next;
        }

        return Head;
    }
}