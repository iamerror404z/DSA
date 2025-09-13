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
    ListNode hd=null,tl=null;

    public void add(int n){
        ListNode curr=new ListNode(n);
        if(hd==null){
            hd=curr;
            return;
        }
        if(tl==null){
            tl=curr;
            hd.next=tl;
            return;
        }
        tl.next=curr;
        tl=curr;
    }

    public void rec(ListNode curr){
        if(curr==null){
            return;}
        
        rec(curr.next);
        add(curr.val);
        
    }

    public int pairSum(ListNode head) {
        
        rec(head);
        ListNode curr=head;

        int len=0;

        while(curr!=null){
            curr=curr.next;
            len++;
        }

        int pos=0;

        ListNode left=head;
        ListNode right=hd;
        int max=0;

        while(pos!=(len/2)){
            max=Math.max(max,left.val+right.val);
            left=left.next;
            right=right.next;
            pos++;
        }



        return max;
    }
}