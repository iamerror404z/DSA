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
    List<Integer> lst=new LinkedList<>();

    public void recursion(TreeNode curr){
        if(curr==null){
            return;
        }
        recursion(curr.left);
        lst.add(curr.val);
        recursion(curr.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        

        recursion(root);

        return lst;
    }
}