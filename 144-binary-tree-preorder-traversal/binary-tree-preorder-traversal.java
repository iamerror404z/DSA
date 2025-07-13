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
    public static void preOrder(List<Integer> ans,TreeNode curr){
        if(curr==null){
            return;
        }
        ans.add(curr.val);
        preOrder(ans,curr.left);
        preOrder(ans,curr.right);

    }
        
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst=new ArrayList<>();
        Solution sl=new Solution();
        sl.preOrder(lst,root);
        



        return lst;
    }
}