/*
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

    public int[] dominantCount(TreeNode curr){
        if(curr==null){
            return new int[2];
        }

        int[] left=dominantCount(curr.left);
        int[] right=dominantCount(curr.right);

        int max=Math.max(left[1],right[1]);
        left[0]+=right[0];
     

        if(curr.val>=max){
            left[1]=curr.val;
            left[0]++;

            return left;
        }

        left[1]=max;
        

        return left;
    }

    public int countDominantNodes(TreeNode root) {

        int[] res=dominantCount(root);
        return res[0];
    }
}