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

    public void recursion(TreeNode curr,int level){
        if(curr==null){
            depth=Math.max(depth,level-1);
            return;
        }

        recursion(curr.left,level+1);
        recursion(curr.right,level+1);

    }

    public int maxDepth(TreeNode root) {
        
        int start=1;

        recursion(root,start);

        return depth;
    }
}