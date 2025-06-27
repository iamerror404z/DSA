/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Operation{
    ListNode head=null;
    ListNode tail=null;

    public ListNode  add(int n){
        ListNode ls=new ListNode(n);
        if(head==null){
            head=ls;
            return head;
        }if(tail==null){
            tail=ls;
            head.next=ls;
            return head;
        }
            tail.next=ls;
            tail=ls;
            return head;

    }
}


class Solution {
    public void deleteNode(ListNode node) {
        ListNode Node=node.next;
        ListNode ans=null;
        Operation op=new Operation();

        while(Node!=null){
            ans=op.add(Node.val);
            Node=Node.next;
        }
        ListNode pos=node;
        
        while(ans.next!=null){
            pos.val=ans.val;
            pos=pos.next;
            ans=ans.next;
        }
        if(ans.next==null){
            pos.val=ans.val;
            pos.next=null;
        }
        
    }
}