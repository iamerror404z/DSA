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

        boolean hasLeft=(curr.left!=null),hasRight=(curr.right!=null);

        if(hasLeft && hasRight){
            int[] left=dfs(curr.left,max);
            int[] right=dfs(curr.right,max);

            int leftMax1=Math.abs(curr.val-left[0]);
            int leftMax2=Math.abs(curr.val-left[1]);
            int leftMax=Math.max(leftMax1,leftMax2);

            int rightMax1=Math.abs(curr.val-right[0]);
            int rightMax2=Math.abs(curr.val-right[1]);
            int rightMax=Math.max(rightMax1,rightMax2);


            max[0]=Math.max(max[0],Math.max(leftMax,rightMax));
            res[0]=Math.min(Math.min(left[0],right[0]),curr.val);
            res[1]=Math.max(Math.max(right[1],left[1]),curr.val);

            
            return res;

        }else if(hasLeft){
            int[] left=dfs(curr.left,max);

            int leftMax1=Math.abs(left[0]-curr.val);
            int leftMax2=Math.abs(left[1]-curr.val);

            max[0]=Math.max(max[0],Math.max(leftMax1,leftMax2));
            
            res[0]=Math.min(left[0],curr.val);
            res[1]=Math.max(left[1],curr.val);

            return res;    

        }else if(hasRight){
            int[] right=dfs(curr.right,max);
            int rightMax1=Math.abs(curr.val-right[0]);
            int rightMax2=Math.abs(curr.val-right[1]);


            max[0]=Math.max(max[0],Math.max(rightMax1,rightMax2));

            res[0]=Math.min(curr.val,right[0]);
            res[1]=Math.max(curr.val,right[1]);

            return res;  
        }

        res[0]=curr.val;
        res[1]=curr.val;



        return res;
    }



    public int maxAncestorDiff(TreeNode root) {
     int[] ans=new int[1];

        dfs(root,ans);


        return ans[0];
    }
}