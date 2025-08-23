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
    int  sum=0;
    public void recursion(TreeNode curr,int low,int high){
        if(curr==null){
            return;
        }
        if(curr.val>=low && curr.val<=high){
            sum+=curr.val;
        }


        recursion(curr.left,low,high);
        recursion(curr.right,low,high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        recursion(root,low,high);

        return sum;
    }
}