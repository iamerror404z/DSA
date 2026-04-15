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
    public int dfs(TreeNode curr,int above){
        if(curr==null){
            return 0;
        }

        if(curr.left==null && curr.right==null){
            if(above!=0){
                curr.val+=above;
            }

            return curr.val;
        }
        int rightDown=dfs(curr.right,above);

        if(above!=0 && curr.right!=null){
            rightDown=(rightDown-above);
            
        }


        curr.val+=rightDown+above;

        int leftDown=dfs(curr.left,curr.val);

        if(curr.left!=null){
            leftDown-=curr.val;
        }
        



        return curr.val+leftDown;
    }


    public TreeNode bstToGst(TreeNode root) {
        dfs(root,0);

        return root;
    }
}