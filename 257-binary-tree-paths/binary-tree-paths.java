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
    List<String> lst=new ArrayList<>();
    public void Recursion(TreeNode curr,String step){
        if(curr==null){
            return;}
        
        if(curr.left==null && curr.right==null){
            step+=(curr.val);
            
            lst.add(step);
            return ;
        }
        Recursion(curr.left,step+curr.val+"->");
        Recursion(curr.right,step+(curr.val)+"->");


    }
    public List<String> binaryTreePaths(TreeNode root) {
        Recursion(root,new String());
        return lst;
    }
}