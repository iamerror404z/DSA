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
    int sum=0;
    public void Recursion(TreeNode curr,boolean left){
        if(curr==null){
            return;
        }
        if(curr.left==null && curr.right==null){
            if(left){
                sum+=curr.val;
            }

            return;
        }
        Recursion(curr.left,true);
        Recursion(curr.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        
        Recursion(root,false);
        return sum;
    }
}