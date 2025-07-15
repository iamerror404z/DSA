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
    public int ans=0;
    int step=0;
    public void inOrder(TreeNode curr,int target){
        if(curr==null){
            return ;
        }
        inOrder(curr.left,target);
            
        if(step==target){
            // System.out.println(curr.val+"   vs  "+step+"   eee"+target);
            
            ans=curr.val;
        }
        step++;
        inOrder(curr.right,target);
    }

    public int kthSmallest(TreeNode root, int k) {
        // int ans=0,step=0;
        inOrder(root,k-1);

        return ans;
        
    }
}