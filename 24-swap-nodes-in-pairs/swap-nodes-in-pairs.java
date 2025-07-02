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
    public ListNode swapPairs(ListNode head) {
        ListNode curr=null,header=null,tail=null,point1,point2,tempHead;
        curr=head;
        if(curr==null || curr.next==null){
            return head;
        }
        point1=curr.next;
        point2=curr;
        tail=point1.next;
        point1.next=point2;
        point2.next=tail;
        tempHead=point1;
        header=point2;
        curr=point2.next;

        while(curr!=null && curr.next!=null){
            tail=curr.next.next;
            point1=curr.next;
            point2=curr;
            point2.next=tail;
            point1.next=point2;
            header.next=point1;
            curr=point2.next;
            header=point2;

        }

        return tempHead;

        
    }
}