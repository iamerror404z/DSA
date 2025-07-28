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
    public ListNode Head=null,Tail=null;
    public void add(int n){
        ListNode node=new ListNode(n);
        if(Head==null){
            Head=node;
            return;
        }if(Tail==null){
            Tail=node;
            Head.next=Tail;
            return;
        }
        Tail.next=node;
        Tail=node;
        return;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode curr=head;
        ListNode aHead=null;
        ListNode point1=null;
         while(curr!=null && curr.val<x){
            add(curr.val);
            curr.val=747;
             curr=curr.next;
         }
            point1=curr;
         while(curr!=null){
            if(curr.val<x){
                add(curr.val);
                curr.val=747;
            }
            curr=curr.next;
         }
        curr=head;
        while(curr!=null){
            if(curr.val!=747){
                add(curr.val);
                curr.val=747;}
                curr=curr.next;
            
        }



        return Head;
    }
}