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
    int temp=0;
    TreeNode head;

    public void sum(TreeNode curr,int val){
        if(curr==null){
            return;
        }
        val+=curr.val;


        if((curr.left==null && curr.right==null) && curr!=head){
            temp+=val;
        }
        sum(curr.left,val*10);
        sum(curr.right,val*10);

    }

    public int sumNumbers(TreeNode root) {
        if(root.left==null && root.right==null){
            return root.val;
        }
        
        head=root;
        sum(root,0);

        return temp;   
    }

}