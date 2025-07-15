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
    int step=0;
    
    public void inOrder(TreeNode curr){
        if(curr==null){
            return ;
        }
        inOrder(curr.left);
        lst.add(curr.val);
        inOrder(curr.right);
        }



    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        
        for(int i=1;i<lst.size();i++){
            if(lst.get(i)<=lst.get(i-1)){
                return false;
            }
        }
        
        return true;
        
    }
}