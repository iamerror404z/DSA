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
    List<Integer> lst=new LinkedList<Integer>();
    public void recursions(TreeNode curr){
        if(curr==null){
            return;
        }
        recursions(curr.left);
        lst.add(curr.val);
        recursions(curr.right);
        
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        recursions(root1);
        recursions(root2);
        Collections.sort(lst);




        return lst;
    }
}