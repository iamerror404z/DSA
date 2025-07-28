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
    int min=Integer.MAX_VALUE;
    public void findMin(TreeNode curr,int path){
        if(curr==null){
            return;
        }
        if(curr.left==null  && curr.right==null){
            min=Math.min(min,path+1);
            return;
        }
        findMin(curr.left,path+1);
        findMin(curr.right,path+1);
    }
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        findMin( root,0);

        return min;
    }
}