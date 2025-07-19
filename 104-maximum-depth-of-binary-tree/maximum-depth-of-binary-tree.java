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
    int ans=0;
    public void maxDep(TreeNode curr,int step){
        if(curr==null){
            ans=Math.max(ans,step);
            return ;
        }
        step++;
        maxDep(curr.left,step);
        maxDep(curr.right,step);
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int step=0;
        maxDep(root,step);

        return ans;

    }
}