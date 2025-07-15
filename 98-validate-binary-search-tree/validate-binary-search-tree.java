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
    int step=0;
    int prev=0;
    boolean ans=true;
    
    public void inOrder(TreeNode curr){
        if(curr==null){
            return ;
        }
        inOrder(curr.left);
        if(step!=0&&prev>=curr.val){
            ans=false;
        }
        prev=curr.val;
        step++;
        inOrder(curr.right);
        }



    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        
        
        return ans;
        
    }
}