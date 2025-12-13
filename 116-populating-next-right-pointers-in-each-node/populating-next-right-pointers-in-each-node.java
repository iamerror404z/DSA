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
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<>();
            queue.offer(root);
            if(root==null){
                return root;
            }

            
            while(queue.size()!=0){
                Node prev=queue.poll();
                int size=queue.size();
                if(prev.left!=null){
                queue.offer(prev.left);
                queue.offer(prev.right);}

                
                for(int i=0;i<size;i++){
                    Node curr=queue.poll();
                    prev.next=curr;

                    if(curr.left!=null){
                    queue.offer(curr.left);
                    queue.offer(curr.right);}
                    // curr.left=null;
                    // curr.right=null;
                    prev=curr;
                }

            }
            
            return root;
        }
    }
