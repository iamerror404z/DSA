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

    public int  dfs(TreeNode curr,int target,boolean[] flag,int size){
        if(curr==null){
            return 0;
        }


        int left=dfs(curr.left,target,flag,size);
        int right=dfs(curr.right,target,flag,size);

        if(curr.val==target){
            int up=size-(left+right+1);
            int max=Math.max(left,right);
            max=Math.max(max,up);
            int min=left+right+up-max;

            flag[0]=flag[0]||max>min;
        }


        return left+right+1;

    }




    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        boolean flag[]=new boolean[1];

        dfs(root,x,flag,n);


        return flag[0];
    }
}