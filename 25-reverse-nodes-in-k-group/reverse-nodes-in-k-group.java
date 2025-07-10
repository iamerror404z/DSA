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
    public void rev(ListNode hd){
        ListNode prev=null, Nxt=null,curr=hd;

        while(curr!=null){
            Nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Nxt;
        }
    }




    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0;
        ListNode curr=head;
        

        while(curr!=null){
            len++;
            curr=curr.next;
        }

        if(k==1 || len==1){
            return head;
        }

        int point=0;
        ListNode start=null,end=null,way1=null,way2=null;
        curr=head;
        start=curr;

        while(point<k-1 ){
            point++;
            curr=curr.next;
        }
        end=curr;
        way2=end.next;
        end.next=null;

        rev(start);

        start.next=way2;
        head=end;
        curr=start;
        int rem=len-k;

        while(rem>=k && curr!=null){
            way1=curr;

            curr=curr.next;
            start=curr;
            way1.next=null;

            for(int i=0;i<k-1;i++){
                curr=curr.next;
            }
            end=curr;
            way2=curr.next;
            end.next=null;
            

            rev(start);
            way1.next=end;
            start.next=way2;

            curr=start;



            rem-=k;
        }




        return head;
    }
}