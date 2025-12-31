/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {



    public Node[] recursion(Node head){
        Node curr=head;
        Node[] range=new Node[2];
        range[0]=head;
        
        Node prev=null;

        while(curr!=null){

            if(curr.child!=null){
                Node[] pos=recursion(curr.child);
                curr.child=null;
                Node next=curr.next;

                curr.next=pos[0];
                pos[0].prev=curr;

                pos[1].next=next;

                if(next!=null){
                    next.prev=pos[1];
                }
                curr=pos[1];

            }
            
            prev=curr;
            curr=curr.next;
        }


        range[1]=prev;

        return range;
    }


    public Node flatten(Node head) {
        if(head==null){
            return head;
        }


        Node[] res=recursion(head);
        

        


        return res[0];

    }
}