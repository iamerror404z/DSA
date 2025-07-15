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
    LinkedList<Integer> lst=new LinkedList<>();

    public void preOrder(TreeNode curr,LinkedList<Integer> list){
        if(curr==null){
            return;
        }
        list.add(curr.val);
        preOrder(curr.left,list);
        preOrder(curr.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        preOrder(root,lst);

        Collections.sort(lst);
        return lst.get(k-1);
        
    }
}