/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode curr,TreeNode p,TreeNode q){
        if(curr==null || curr==p || curr==q){
            return curr;
        }

        TreeNode left=lowestCommonAncestor(curr.left,p,q);
        TreeNode right=lowestCommonAncestor(curr.right,p,q);

        if(left==null){
            return right;
        }

        if(right==null){
            return left;
        }

        return curr;

    }
}