/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int  depth=0;

    public void levelOrder(TreeNode curr,int ll){
        if(curr==null){
            depth=Math.max(depth,ll-1);
            return;
        }

        levelOrder(curr.left,ll+1);
        levelOrder(curr.right,ll+1);


    }

    public void levelOrder(TreeNode curr,int level,List<List<Integer>> list){
        if(curr==null){
            return;
        }

        list.get(level).add(curr.val);

        levelOrder(curr.left,level+1,list);
        levelOrder(curr.right,level+1,list);

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outer=new LinkedList<>();
        levelOrder(root,1);
        for(int i=0;i<depth;i++){
            List<Integer> inner=new LinkedList<>();
            outer.add(inner);
        }

        levelOrder(root,0,outer);


        return outer;
    }
}