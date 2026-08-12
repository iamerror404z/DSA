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
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return new LinkedList<>();
        }
        List<List<Integer>> wrapped=new LinkedList<>();

        Queue<List<Node>> queue=new LinkedList<>();
        List<Node> rootList=new LinkedList<>();
        rootList.add(root);

        queue.add(rootList);

        while(!queue.isEmpty()){
            List<Integer> inner=new LinkedList<>();
            int size=queue.size();

            for(int i=0;i<size;i++){
                List<Node> childrens=queue.poll();

                int childrensSize=childrens.size();
                
                for(int j=0;j<childrensSize;j++){
                    Node curr=null;
                    curr=childrens.get(j);
                    
                    inner.add(curr.val);

                    if(curr.children.size()!=0){
                        queue.add(curr.children);
                    }
                }
            }

           


            wrapped.add(inner);
        }



        System.out.println("List is : "+wrapped);
        return wrapped;
    }
}