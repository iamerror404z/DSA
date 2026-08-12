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
/**
    done with the bfs approach not much efficient now going to apply dfs
 
 */

class Solution {

    public void dfs(Node curr,int level,List<List<Integer>> wrapped){
        if(wrapped.size()<=level){
            wrapped.add(new LinkedList<>());
        }

        wrapped.get(level).add(curr.val);

        for(int i=0;i<curr.children.size();i++){
            Node child=curr.children.get(i);
            dfs(child,level+1,wrapped);
        }


    }


    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return new LinkedList<>();
        }

        List<List<Integer>> wrapped=new LinkedList<>();


        dfs(root,0,wrapped);
        return wrapped;
    }
}