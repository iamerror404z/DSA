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
    int len=0;
    public void change(ListNode curr,int pos){
        if(len==0 || pos==0){
            return;
        }

        if(pos%2==0){
            int move=0;
            ListNode previous=curr;
            ListNode temphead=curr.next;


            while(curr!=null && move!=pos){
                move++;
                curr=curr.next;
            }
            ListNode temptail=curr;
            ListNode nexter=curr.next;

            previous.next=null;
            temptail.next=null;

            curr=temphead;

            ListNode next=null,prev=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            previous.next=temptail;
            temphead.next=nexter;

            len-=move;

            pos=Math.min(pos+1,len);

            System.out.println("even");
            if(curr!=null){
            System.out.println("next node: "+curr.val);}
            System.out.println("pos : "+pos);
            System.out.println("len: "+len);

            

            if(pos%2!=0){
                change(nexter,pos);
            }else{
                change(temphead,pos);
            }




        }else{
            int move=0;

            while(curr!=null && move!=pos-1){
                move++;
                curr=curr.next;
            }
            len-=(move+1);
            pos=Math.min(pos+1,len);

            System.out.println("odd");
            System.out.println("pos: "+pos);
            System.out.println("node to be passed : "+curr.val);
            System.out.println("\n\n");


            
            if(pos%2==0){
                change(curr,pos);
            }else{
                return ;
            }
        
        }

       
        
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int l=0;
        ListNode curr=head;

        while(curr!=null){
            curr=curr.next;
            l++;
        }
        len=l;


        change(head,1);

        return head;
        
    }
}