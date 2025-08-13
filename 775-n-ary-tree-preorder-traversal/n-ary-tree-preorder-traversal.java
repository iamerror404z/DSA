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
};
*/

class Solution {
    public List<Integer> lst=new LinkedList<Integer>();
    public void method(List<Node> nodes){
        if(nodes.isEmpty()){
            return ;
        }
        for(Node curr:nodes){
            lst.add(curr.val);
            method(curr.children);
        }

    }
    public List<Integer> preorder(Node root) {
        List<Node> start=new LinkedList<Node>();
        if(root==null){
            return lst;
        }
        start.add(root);

        method(start);

        return lst;
    }
}