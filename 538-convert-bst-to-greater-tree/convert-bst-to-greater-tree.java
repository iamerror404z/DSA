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

    public int dfs(TreeNode curr,int runSum){
        if(curr==null){
            return 0;
        }

        int right=dfs(curr.right,runSum);
        curr.val+=right+runSum;
        int left=dfs(curr.left,curr.val);

        int currSum=curr.val;

        if(runSum!=0){
            currSum=currSum-runSum;
        }


        return left+currSum;
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root,0);


        return root;
    }
}