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
    public TreeNode[] dfs(TreeNode curr,int level){
        if(curr==null){
            TreeNode[] res=new TreeNode[2];
            res[1]=new TreeNode(-1);

            return res;
        }

        TreeNode[] left=dfs(curr.left,level+1);
        TreeNode[] right=dfs(curr.right,level+1);

        if(left[1].val==right[1].val){
            left[0]=curr;
            
            if(level>left[1].val){
                left[1]=new TreeNode(level);

            }

            return left;
        }else if(left[1].val>right[1].val){
            return left;
        }





        return right;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode[] res=dfs(root,0);        

        return res[0];
        
    }
}