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
    List<List<Integer>> ans=new ArrayList<>();
    public void recursion(TreeNode curr,int target,List<Integer> path,int sum){
        if(curr==null){
            return;}
        
        if(curr.left==null && curr.right==null && sum+curr.val==target ){
            System.out.println(curr.val);
            path.add(curr.val);
            ans.add(path);
            return;
        }
        path.add(curr.val);
        recursion(curr.left,target,new ArrayList<>(path),sum+curr.val);
        recursion(curr.right,target,new ArrayList<>(path),sum+curr.val);




    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> step=new ArrayList<>();
        recursion(root,targetSum,step,0);

        return ans;
    }
}