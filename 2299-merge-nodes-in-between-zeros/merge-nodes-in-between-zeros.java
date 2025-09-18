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
    ListNode Head=null;
    ListNode tail=null;

    public void add(int n){
        ListNode curr=new ListNode(n);

        if(Head==null){
            Head=curr;
            return;
        }

        if(tail==null){
            tail=curr;
            Head.next=tail;
            return;
        }
        tail.next=curr;
        tail=curr;

    }


    public ListNode mergeNodes(ListNode head) {
        ListNode left=head,right=null;

        while(left!=null){
            right=left.next;
            int sum=0;
            while(right!=null && right.val!=0){
                sum+=right.val;
                right=right.next;
            }
            
            if(sum!=0){
            add(sum);}

            left=right;
        }

        
        return Head;
        
    }
}