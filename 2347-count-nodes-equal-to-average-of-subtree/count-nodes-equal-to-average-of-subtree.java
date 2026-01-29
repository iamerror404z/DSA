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
        int[] ans=new int[3];
        if(curr==null){
            return ans;
        }

        int[] left=dfs(curr.left);
        int[] right=dfs(curr.right);

        for(int i=0;i<3;i++){
            ans[i]=left[i]+right[i];
        }
        
        ans[0]++;
        ans[1]+=curr.val;

        if(ans[1]/ans[0]==curr.val){
            ans[2]++;
        }

        
        return ans;

    }

    public int averageOfSubtree(TreeNode root) {
        int[] ans=dfs(root);

        // System.out.println(Arrays.toString(ans));

        return ans[2];
    }
}