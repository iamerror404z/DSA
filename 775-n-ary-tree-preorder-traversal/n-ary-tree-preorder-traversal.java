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
    List<Integer> lst=new LinkedList<>();

    public void answer(List<Node> nodes){
        if(nodes.isEmpty()){
            return;
        }
        for(Node n:nodes){
            lst.add(n.val);
            answer(n.children);
        }

    }

    public List<Integer> preorder(Node root) {
        if(root==null){
            return new LinkedList<>();
        }
        List<Node> list=new LinkedList<>();
        list.add(root);

        answer(list);

        return lst;
    }
}