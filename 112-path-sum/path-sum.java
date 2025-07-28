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
    public boolean ans=false;
    public void pathFind(TreeNode curr,int sum,int target){
        if(curr==null){
            return;
        }
        if(curr.left==null && curr.right==null &&(sum+curr.val)==target){
         ans=true;
         return;}
         pathFind(curr.left,sum+curr.val,target);
         pathFind(curr.right,sum+curr.val,target);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        pathFind(root,0,targetSum);


        return ans;
    }
}