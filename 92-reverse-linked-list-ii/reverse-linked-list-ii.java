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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        left-=1;
        right-=1;
        int c=0;
        ListNode ans=null;

        int len=0;
        ListNode curr=head,start=null,end=null,Tail=null;
        ListNode firstT=null;

        while(curr!=null){
            if(c==left-1){
                firstT=curr;
            }if(c==left){
                start=curr;
            }if(c==right){
                end=curr;
                Tail=curr.next;
            }len++;
            c++;
            curr=curr.next;
            
        }
        if(left==right || len<=1){
            return head;
        }
        if(firstT==null){
            ans=end;
        }else { 
            ans = head;
            firstT.next=null;
        }
        end.next=null;

        curr=start;
        ListNode prev=null,next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        if(firstT==null){
            ans=end;
        }else{
            firstT.next=end;
            ans=head;
        }
        start.next=Tail;


        return ans;
        
    }
}