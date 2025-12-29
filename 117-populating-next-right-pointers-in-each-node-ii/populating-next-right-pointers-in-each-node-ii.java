/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public void connector(Queue<Node> queue){
        
        while(queue.size()!=0){
            int size=queue.size();
            Node prev=queue.poll();
            if(prev.left!=null){
                queue.add(prev.left);
            }
            if(prev.right!=null){
                queue.add(prev.right);
            }

            for(int i=1;i<size;i++){
               Node curr=queue.poll();
                prev.next=curr;
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
                prev=curr;

            }
        }

    }


    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<>();
        if(root!=null){
        queue.add(root);}
        connector(queue);


        return root;
    }
}