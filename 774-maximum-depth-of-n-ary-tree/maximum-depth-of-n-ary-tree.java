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
    int max=0;
    public void Depth(List<Node> lst,int step){
        if(lst.isEmpty()){
            return;
        }
        max=Math.max(max,step);
        List<TreeNode> next=new LinkedList<>();
        for(Node curr:lst){
            Depth(curr.children,step+1);
        }

    }
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        List<Node> lst=new LinkedList<>();
        lst.add(root);
        
        Depth(lst,1);
        
        
        return max;
    }
}