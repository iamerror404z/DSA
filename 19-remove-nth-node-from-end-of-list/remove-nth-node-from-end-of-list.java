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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head,tail=null;
        int size=1;
        while(temp.next!=null){
            size++;
            temp=temp.next;
            tail=temp;
        }
        temp=head;
        int target=size-n;
        System.out.println(target+" vs "+size);
        if(target==0){ temp=head.next;
        // System.out.println(target+" vs  "++" vs"+temp);
            // head.next=null;
            // head=temp;
            return temp;}
        int check=1;
        temp=head;
        while(temp!=tail){
            if(check==target){
                temp.next=temp.next.next;
                break;
            }
            check++;
            temp=temp.next;
        }
        return head;
        
    }
}