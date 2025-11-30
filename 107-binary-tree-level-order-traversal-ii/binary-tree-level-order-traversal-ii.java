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
    int max=0;
    public void depth(TreeNode curr,int level){
        if(curr==null){
            max=Math.max(max,level-1);
            return;
        }

        depth(curr.left,level+1);
        depth(curr.right,level+1);

    }

    
    public void depth(TreeNode curr,int level,List<List<Integer>> list){
        if(curr==null){
            return;
        }
        list.get(max-level).add(curr.val);
        

        depth(curr.left,level+1,list);
        depth(curr.right,level+1,list);

    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        
        depth(root,1); 
        
        for(int i=0;i<max;i++){
            List<Integer> inner=new LinkedList<>();
            list.add(inner);
        }

        max--;
        depth(root,0,list);



        return list;
    }
}