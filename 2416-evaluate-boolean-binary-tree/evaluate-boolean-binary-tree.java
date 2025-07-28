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
    public void evaluate(TreeNode curr){
        if(curr==null ||curr.val<=1){
            return;
        }
        evaluate(curr.left);
        evaluate(curr.right);
        if(curr.val==2){
            curr.val=(curr.left.val)|(curr.right.val);
        }else if(curr.val==3){
            curr.val=(curr.left.val)&(curr.right.val);
        }
    }
    public boolean evaluateTree(TreeNode root) {
        evaluate(root);
        
        return root.val==1;
    }
}