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
    public boolean dfs(TreeNode curr1,TreeNode curr2,boolean flag[]){
        if(!flag[0]){
            return false;
        }

        if(curr1==null && curr2==null){
            return true;
        }


        if((curr1==null && curr2!=null) || (curr1!=null && curr2==null)){
            return false;
        }

        if(curr1.val!=curr2.val){
            return false;
        }

        boolean node1HasLeft=(curr1.left!=null),node2HasLeft=(curr2.left!=null);
        boolean node1HasRight=(curr1.right!=null),node2HasRight=(curr2.right!=null);

        boolean left=true;
        boolean right=true;

        if(node1HasLeft && node2HasLeft){
            if(curr1.left.val==curr2.left.val){
                left=dfs(curr1.left,curr2.left,flag);
                right=dfs(curr1.right,curr2.right,flag);
            }else{
                left=dfs(curr1.left,curr2.right,flag);
                right=dfs(curr1.right,curr2.left,flag);
            }

        }else if(node1HasLeft && node2HasRight){
            left=dfs(curr1.left,curr2.right,flag);
            right=dfs(curr1.right,curr2.left,flag);
        }
        else if(node1HasRight && node2HasLeft){
            left=dfs(curr1.right,curr2.left,flag);
            right=dfs(curr1.left,curr2.right,flag);
        }
        else if(node1HasRight && node2HasRight){
            left=dfs(curr1.left,curr2.left,flag);
            right=dfs(curr1.right,curr2.right,flag);
        }else{
            left=dfs(curr1.left,curr2.left,flag);
            right=dfs(curr2.right,curr2.right,flag);
        }

        boolean ans=left && right;

        if(flag[0]){
            flag[0]=ans;
        }


        return ans;
    }


    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        boolean[] flag=new boolean[1];
        flag[0]=true;

        
        return dfs(root1,root2,flag);
    }
}