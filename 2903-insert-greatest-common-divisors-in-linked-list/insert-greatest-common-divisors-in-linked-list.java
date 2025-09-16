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

    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        
        return gcd(b,a%b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode curr=head;


        while(curr!=null && curr.next!=null){
            // int gd=gcd(curr.val,curr.next.val);
            ListNode gd=new ListNode(gcd(curr.val,curr.next.val));
            
            ListNode temp=curr.next;
            curr.next=gd;
            gd.next=temp;
            curr=temp;

            System.out.println(gd.val);


        }


        




        return head;
    }
}