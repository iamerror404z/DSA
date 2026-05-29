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

    public TreeNode LCA(TreeNode curr,TreeNode left,TreeNode right){
        if(curr==null){
            return null;
        }

        if(curr.val>=left.val && curr.val<=right.val){
            return curr;
        }

        TreeNode res=null;

        if(curr.val>right.val){
            res=LCA(curr.left,left,right);
        }else{
            res=LCA(curr.right,left,right);
        }


        return res;
     }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            TreeNode temp=p;
            p=q;
            q=temp;

        }

        TreeNode ans=LCA(root,p,q);
        // ans.val+=1;


        return ans;
    }
}