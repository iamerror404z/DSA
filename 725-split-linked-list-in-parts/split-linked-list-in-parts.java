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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans=new ListNode[k];
        int length=0;

        ListNode curr=head;

        while(curr!=null){
            length++;
            curr=curr.next;

        }

        if(length<=k){
            curr=head;
            for(int i=0;i<length;i++){
                ans[i]=curr;
                ListNode next=curr.next;
                curr.next=null;
                curr=next;
            }

            
        return ans;
        }

        int part=length/k;
        int rem=length%k;

        // System.out.println("part is : "+part+"\n rem is : "+rem);

        curr=head;
        int pointer=0;


        while(curr!=null){
            ListNode header=curr;
            int move=1;
            while(move!=part && curr!=null){
                curr=curr.next;
                move++;
            }
        ListNode next=curr.next;
        if(rem!=0){
            curr=curr.next;
            next=curr.next;
            rem--;
        }
        ans[pointer++]=header;

        curr.next=null;
        curr=next;

        }




        return ans;

    }
}