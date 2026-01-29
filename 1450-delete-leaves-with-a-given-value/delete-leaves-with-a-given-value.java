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
    
    public TreeNode dfs(TreeNode curr,int target){
        if(curr==null){
            return null;
        }

        TreeNode left=dfs(curr.left,target);
        TreeNode right=dfs(curr.right,target);
        
        if(left==null && right==null && curr.val==target){
            return null;
        }

        curr.left=left;
        curr.right=right;
        

        return curr;
    }


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
     return dfs(root,target);   
    }
}