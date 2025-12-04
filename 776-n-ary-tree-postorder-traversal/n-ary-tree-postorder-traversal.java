/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> list=new LinkedList<>();

    public void Order(List<Node> nodes){
        if(nodes.isEmpty()){
            return;
        }
        
        for(Node n:nodes){
            Order(n.children);
            list.add(n.val);
        }

    }

    public List<Integer> postorder(Node root) {
        List<Node> nodes=new LinkedList<>();
        if(root!=null){
        nodes.add(root);}
        Order(nodes);
        return list;
    }
}