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
        String ans="";
        ListNode temp=head;

        while(temp!=null){
            // bin.append(temp.val);
            ans+=temp.val;
            temp=temp.next;
        }

        return Integer.parseInt(ans,2);
        
    }
}