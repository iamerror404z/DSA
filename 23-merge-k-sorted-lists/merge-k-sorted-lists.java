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

public class Operation{
    ListNode head=null;
    ListNode tail=null;

    public ListNode add(int n){
        ListNode ls=new ListNode();
        ls.val=n;
        if(head==null){
        head=ls;
        return head;
        }

        if(tail==null){
            tail=ls;
            head.next=tail;
            return head;
        }
           
        tail.next=ls;
        tail=ls;
        return head;

    
    }



}


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<Integer> ts=new LinkedList<>();
        Operation op=new Operation();
        ListNode ans=null;
        ListNode temp=new ListNode();
        

        for(ListNode head:lists){
            ListNode curr=head;
            while(curr!=null){
                ts.add(curr.val);
                curr=curr.next;
            }
        }
        Collections.sort(ts);

        for(int i:ts){
            
            ans=op.add(i);
        }
    


    return ans;
    }
}