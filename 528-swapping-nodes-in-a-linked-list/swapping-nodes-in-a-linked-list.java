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
    public ListNode swapNodes(ListNode head, int k) {
        int len=0,var=0;
        ListNode  curr=head;

        while(curr!=null){
            len++;
            curr=curr.next;
        }

        k=k-1;
        len=len-1;
        int target2=len-k;
        int target1=k;
        

        ListNode temp1=null,temp2=null;
        int pos1=0,pos2=0;
        curr=head;
        while(pos1!=target1 && curr!=null){
            pos1++;
            curr=curr.next;
        }
        temp1=curr;
        curr=head;
        while(pos2!=target2 && curr!=null){
            pos2++;
            curr=curr.next;
        }
        temp2=curr;

        var=temp1.val;
        temp1.val=temp2.val;
        temp2.val=var;


        return head;
        
    }
}