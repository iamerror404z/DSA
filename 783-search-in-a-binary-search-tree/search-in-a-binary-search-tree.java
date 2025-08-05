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
    TreeNode ans=null;
    public void search(TreeNode curr,int target){
        if(curr==null){
            return;
        }
        if(curr.val==target){
            ans=curr;
            return;
        }
        if(target<curr.val){
            search(curr.left,target);
        }
        else{
            search(curr.right,target);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        search(root,val);


        return ans;


    }
}