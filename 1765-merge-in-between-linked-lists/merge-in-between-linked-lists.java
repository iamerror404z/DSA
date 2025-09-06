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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // ListNode head=list1;
        ListNode curr=list1;
        int point=0;
        while(curr!=null && point!=a-1){
            point++;
            curr=curr.next;
        }
        ListNode start=curr;
        
        while(curr!=null && point!=b){
            point++;
            curr=curr.next;
        }
        ListNode end=curr.next;
        ListNode tail=null;
        curr=list2;
        while(curr.next!=null){
            curr=curr.next;
        }
        tail=curr;
        
        start.next=list2;
        tail.next=end;



        return list1;
    }
}