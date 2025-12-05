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
    
    public int downWards(TreeNode curr,int[] maxPath){
        if(curr==null){
            return 0;
        }
        int left=Math.max(0,downWards(curr.left,maxPath));
        int right=Math.max(0,downWards(curr.right,maxPath));
        int max=Math.max(left,right);
        maxPath[0]=Math.max(maxPath[0],curr.val+left+right);
        
        return Math.max(left,right)+(curr.val);

    }

    public int maxPathSum(TreeNode root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        downWards(root,max);
        
        return max[0];
    }
}