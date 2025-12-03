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
    int depth=0;

    public void levelOrder(TreeNode curr,int level){
        if(curr==null){
            depth=Math.max(depth,level-1);
            return;
        }

        levelOrder(curr.left,level+1);
        levelOrder(curr.right,level+1);

    }

    public void levelOrder(TreeNode curr,int level,List<List<Integer>> lst){
        if(curr==null){
            return;
        }
        lst.get(level).add(curr.val);

        levelOrder(curr.left,level+1,lst);
        levelOrder(curr.right,level+1,lst);
        
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lst=new LinkedList<>();


        levelOrder(root,1);
        for(int i=0;i<depth;i++){
            lst.add(new LinkedList<>());
        }

        levelOrder(root,0,lst);

        for(int i=1;i<lst.size();i+=2){
            List<Integer> innerlist=lst.get(i);
            int start=0;
            int end=innerlist.size()-1;
            while(start<end){
                int temp=innerlist.get(start);
                innerlist.set(start,innerlist.get(end));
                innerlist.set(end,temp);

                start++;
                end--;
            }
        }

        // System.out.println(lst);
        return lst;
    }
}