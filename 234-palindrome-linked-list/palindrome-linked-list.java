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

    
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev= null;

        while(fast!=null && fast.next!=null){
            
            prev=slow;
            slow=slow.next;
            fast = fast.next.next;
        }

        if(fast!=null){
            ListNode next=slow.next;
            slow.next=null;
            return next;
        }

        prev.next=null;
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev= null;

        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            
            prev=curr;
            curr=next;

        }


        return prev;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode middle=findMiddle(head);

        ListNode forward=head;
        ListNode backward=reverse(middle);

        while(forward!=null && backward!=null){
            if(forward.val!=backward.val){
                return false;
            }


            forward=forward.next;
            backward=backward.next;
        }
        
        return true;
    }
}