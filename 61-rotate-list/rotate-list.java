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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr=head,tail=null;
        int point=0;
        int len=0;

        while(curr!=null){
            len++;
            tail=curr;
            curr=curr.next;
        }

        if(len==0){
            return head;
        }

        if(k>=len){
            k=k%len;
        }
        if(k==0){
            return head;
        }



        int target=len-k;
        int pos=0;
        
        curr=head;
        while(pos!=target-1 && curr!=null){
            curr=curr.next;
            pos++;
        }

        {
            ListNode tempHead=curr.next;
            curr.next=null;
            tail.next=head;
            head=tempHead;

        }


        return head;
    }
}