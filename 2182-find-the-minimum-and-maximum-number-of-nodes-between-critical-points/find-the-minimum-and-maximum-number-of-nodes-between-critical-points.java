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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans=new int[2];
        ans[0]=Integer.MAX_VALUE;
        ans[1]=0;
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode next=curr.next;
        int pos=1;
        
        int start=Integer.MAX_VALUE;
        int end=-1;

        int previous=-1;
        


        while(curr!=null && next!=null){

            if ((curr.val>prev.val && curr.val>next.val) || (curr.val<prev.val && curr.val<next.val)){
                // System.out.println("it works");
                start=Math.min(start,pos);
                end=Math.max(end,pos);
                if(previous!=-1){
                    ans[0]=Math.min(ans[0],pos-previous);
                }
                previous=pos;
                
                }



            pos++;
            prev=prev.next;
            curr=curr.next;
            next=next.next;
        }

        ans[1]=end-start;

        if(ans[0]==Integer.MAX_VALUE){
            ans[0]=-1;
            ans[1]=-1;
        }





        return ans;
        
    }
}