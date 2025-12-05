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
    int maxPath=Integer.MIN_VALUE;

    public int downWards(TreeNode curr){
        if(curr==null){
            return 0;
        }
        int left=Math.max(0,downWards(curr.left));
        int right=Math.max(0,downWards(curr.right));
        int max=Math.max(left,right);
        maxPath=Math.max(maxPath,curr.val+left+right);
        System.out.println(maxPath);

        return Math.max(left,right)+(curr.val);

    }

    public int maxPathSum(TreeNode root) {
        downWards(root);
        
        return maxPath;
    }
}