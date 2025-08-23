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
    int min=Integer.MAX_VALUE;
    int min2=Integer.MAX_VALUE;
    boolean proceed=false;
    boolean found=false;
    

    public void ans(TreeNode curr){
        if(curr==null){
            return ;
        }
        if(curr.val<min){
            min=curr.val;
        }
        if(proceed){
            if(curr.val<=min2 && curr.val!=min){
                min2=curr.val;
                found=true;
            }
        }
        ans(curr.left);
        ans(curr.right);

    }
    public int findSecondMinimumValue(TreeNode root) {
        
        ans(root);
        proceed=true;
        ans(root);

        if(found){
            return min2;
        }
        return -1;
    }
}