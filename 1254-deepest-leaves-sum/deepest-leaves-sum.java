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
    int sum=0;
    int depth=0;
    public void Depth(TreeNode curr,int level){
        if(curr==null){
            return ;
        }
        depth=Math.max(depth,level);
        Depth(curr.left,level+1);
        Depth(curr.right,level+1);

    }
    public void adder(TreeNode curr,int level,int D){
        if(curr==null){
            return;
        }
        if(level==D){
            sum+=curr.val;
        }
        adder(curr.right,level+1,D);
        adder(curr.left,level+1,D);
    }
    public int deepestLeavesSum(TreeNode root) {
        Depth(root,1);
        adder(root,1,depth);
    
       
       return sum; 
    }
}