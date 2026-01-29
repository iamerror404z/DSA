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
    public void dfs(TreeNode curr,int pass,int[] count){
        if(curr==null){
            return;
        }

        if(curr.val>=pass){
            count[0]++;
        }

        pass=Math.max(pass,curr.val);

        dfs(curr.left,pass,count);
        dfs(curr.right,pass,count);


    }

    public int goodNodes(TreeNode root) {
        int count[]=new int[1];
        
        dfs(root,root.val,count);

        return count[0];
    }
}