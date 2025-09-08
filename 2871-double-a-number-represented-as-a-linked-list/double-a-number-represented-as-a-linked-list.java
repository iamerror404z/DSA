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
 import java.math.*;


class Solution {
    ListNode hd=null;
    ListNode tl=null;

    public void adder(int n){
        ListNode curr=new ListNode(n);
        if(hd==null){
            hd=curr;
            return;
        }if(tl==null){
            tl=curr;
            hd.next=tl;
            return;
        }
        tl.next=curr;
        tl=curr;
    }
    public ListNode doubleIt(ListNode head) {
       StringBuilder sb=new StringBuilder();
        ListNode curr=head;
        long size=0;


        while(curr!=null){
            sb.append(curr.val);
            curr=curr.next;
            size++;
        }

        BigInteger bg=new BigInteger(sb.toString());
        bg=bg.multiply(new BigInteger("2"));
        String number=bg.toString();
        
        for(int i=0;i<number.length();i++){
            adder(number.charAt(i)-'0');
        }

        return hd;
        
    }
}