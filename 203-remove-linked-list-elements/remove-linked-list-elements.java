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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr=head;
        ListNode hd=null;

        while(curr!=null &&curr.val==val){
            curr=curr.next;
        }
        if(curr==null){
            return curr;
        }

        hd=curr;
        ListNode prev=null;


        while(curr!=null){
            prev=curr;
            curr=curr.next;

            while(curr!=null &&curr.val==val){
            curr=curr.next;}
            prev.next=curr;
        }


        return hd;
    }
}