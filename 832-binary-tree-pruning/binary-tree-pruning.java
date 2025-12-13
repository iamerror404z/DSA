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

    public int backTracking(TreeNode curr){
        if(curr==null){
            return 0;
        }
        int left=backTracking(curr.left);
        int right=backTracking(curr.right);

        if(left==0){
            curr.left=null;
        }
        if(right==0){
            curr.right=null;
        }
        int max=Math.max(left,right);

        return Math.max(max,curr.val);

    }

    public TreeNode pruneTree(TreeNode root) {
        
        backTracking(root);
        if(root.left==null && root.right==null &&root.val==0){
            return null;
        }


        return root;
    }
}