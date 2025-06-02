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
    public int getDecimalValue(ListNode head) {
        StringBuilder bin=new StringBuilder();
        ListNode temp=head;

        while(temp!=null){
            bin.append(temp.val);
            temp=temp.next;
        }

        return Integer.parseInt(bin.toString(),2);
        
    }
}