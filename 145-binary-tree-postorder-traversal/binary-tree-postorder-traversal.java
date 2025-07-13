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
    public void postOrder(List<Integer> lst, TreeNode curr){
        if(curr==null){
            return ;
        }
        postOrder(lst,curr.left);
        postOrder(lst,curr.right);
        lst.add(curr.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst=new ArrayList<Integer>();
        Solution sl=new Solution();
        sl.postOrder(lst,root);

        return lst;
    }
}