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
    public int[] zizagPath(TreeNode curr,int[] max){
        if(curr==null){
            return new int[2];
        }

        int[] left=zizagPath(curr.left,max);
        int[] right=zizagPath(curr.right,max);

        int res[]=new int[2];

        if(curr.left!=null){
            res[0]=1+left[1];
            max[0]=Math.max(max[0],res[0]);
        }

        if(curr.right!=null){
            res[1]=1+right[0];
            max[0]=Math.max(max[0],res[1]);
        }




        return res;

    }



    public int longestZigZag(TreeNode root) {
        int[] max=new int[2];
        zizagPath(root,max);


        return max[0];
    }
}