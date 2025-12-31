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
    

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;


        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }



    public void reorderList(ListNode head) {
        if(head.next==null || head.next.next==null){
            return ;
        }

        ListNode middle=findMiddle(head);
        ListNode end=middle.next;
        middle.next=null;
        end=reverse(end);
        ListNode start=head;

        while(start!=null && end!=null){
            ListNode nextStart=start.next;
            ListNode nextEnd=end.next;

            start.next=end;
            end.next=nextStart;

            start=nextStart;
            end=nextEnd;

            
        }

        
    }
}