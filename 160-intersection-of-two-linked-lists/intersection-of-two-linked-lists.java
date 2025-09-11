/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rev(ListNode head){
        ListNode curr=head;
        ListNode next=null,prev=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curr1=headA;
        ListNode curr2=headB;

        int len1=0;
        int len2=0;

        while(curr1!=null){
            curr1=curr1.next;
            len1++;
        }

        ListNode tempPrev=null;

        while(curr2!=null){
            if(curr2!=null){
                tempPrev=curr2;
            }
            len2++;
            curr2=curr2.next;
            
        }
        curr1=headA;
        

        while(curr1!=null && curr1!=tempPrev){
            curr1=curr1.next;
        }

        if(curr1!=tempPrev){
            return null;
        }

         ListNode tHead=rev(headA);
        ListNode curr=headB;
        
        int newLen=0;


        while(curr!=null){
            newLen++;
            curr=curr.next;
        }
        int pos=len1+len2-newLen+1;
        pos/=2;

        ListNode res=rev(tHead);

        curr=headB;

        int loc=0;

        while (curr!=null && len2-loc!=pos){
            curr=curr.next;
            loc++;
        }



        return curr;
    }
}