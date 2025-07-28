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
    int count=0;
    public void countNode(TreeNode curr){
        if(curr==null){
            return;
        }
        countNode(curr.left);
        countNode(curr.right);
        count++;
    }
    public int countNodes(TreeNode root) {
         countNode(root);

        return count;
    }
}