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
    public void Recursion(TreeNode curr,StringBuilder step){
        if(curr==null){
            return;}
        int len=step.length();
        step.append(curr.val);
        if(curr.left==null && curr.right==null){
            
            lst.add(step.toString());
            step.setLength(len);
            return ;
        }
        step.append("->");
        
        Recursion(curr.left,step);
        Recursion(curr.right,step);
        step.setLength(len); }


    public List<String> binaryTreePaths(TreeNode root) {
        Recursion(root,new StringBuilder());
        return lst;
    }
}