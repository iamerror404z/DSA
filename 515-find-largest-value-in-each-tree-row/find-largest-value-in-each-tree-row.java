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
    List<Integer> max=new ArrayList<>();
    public void row_Wise_Max(List<TreeNode> lst){
        if(lst.isEmpty()){
            return;
        }
        int Max=lst.get(0).val;
        List<TreeNode> list=new ArrayList<>();
        

        for(TreeNode curr:lst){
            if(curr.val>Max){
                Max=curr.val;
            }
            if(curr.left!=null){
                list.add(curr.left);
            }
            if(curr.right!=null){
                list.add(curr.right);
            }}

            max.add(Max);
            row_Wise_Max(list);

        }
    
    public List<Integer> largestValues(TreeNode root) {
        if(root ==null){
            return max;
        }
        List<TreeNode> Lst=new ArrayList<>();
        Lst.add(root);
        row_Wise_Max(Lst);

        return max;
        
    }
}