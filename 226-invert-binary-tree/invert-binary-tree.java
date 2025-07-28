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
    public void Invert(TreeNode curr){
        if(curr==null){
            return;
        }
        if(curr.left==null && curr.right==null){
            return ;
        }
        Invert(curr.left);
        Invert(curr.right);
        TreeNode temp=curr.left;
        curr.left=curr.right;
        curr.right=temp;
    }
    public TreeNode invertTree(TreeNode root) {
        Invert(root);

        return root;
    }
}