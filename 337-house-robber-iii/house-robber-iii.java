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

    public int[] dfs(TreeNode curr){
        if(curr==null){
            return  new int[2];
        }

        int left[]=dfs(curr.left);
        int[] right=dfs(curr.right);

        int withRoot=curr.val+left[1]+right[1];
        int withoutRoot=0+Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        

        int[] res=new int[]{withRoot,withoutRoot};


        return res;

    }




    public int rob(TreeNode root) {
        int[] ans;

        ans=dfs(root);

        return  Math.max(ans[0],ans[1]);
    }
}