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
    public int[] dfs(TreeNode curr,int[] max){
        int[] res=new int[2];

        if(curr==null){
            res[0]=1001;
            return res;
        }

        int[] left=dfs(curr.left,max);
        int[] right=dfs(curr.right,max);

        int edges=0;

        if(left[0]==curr.val){
            left[1]++;
            edges=left[1];
        }
        if(right[0]==curr.val){
            right[1]++;
            if(edges!=0){
                max[0]=Math.max(max[0],left[1]+right[1]);
            }
            edges=Math.max(edges,right[1]);
        }

        


        res[0]=curr.val;
        res[1]=edges;


        max[0]=Math.max(max[0],res[1]);
        return res;

    }


    public int longestUnivaluePath(TreeNode root) {
        int[] max=new int[1];

        dfs(root,max);


        return max[0];
        
    }
}