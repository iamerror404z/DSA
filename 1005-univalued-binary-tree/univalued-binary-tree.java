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
    boolean ans=true;
    public void find(TreeNode curr,int core){
        if(curr==null){
            return;
        }
        ans=ans&(curr.val==core);
        find(curr.left,core);
        find(curr.right,core);

        
    }
    public boolean isUnivalTree(TreeNode root) {
        find(root,root.val);

        return ans;
    }
}