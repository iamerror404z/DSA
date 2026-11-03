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
    public void inOrder(TreeNode curr,List<Integer> list){
        if(curr==null){
            return;
        }

        inOrder(curr.left,list);
        list.add(curr.val);
        inOrder(curr.right,list);

    }

    public TreeNode buildBST(int start,int end,List<Integer> list){
        if(start>end){
            return null;
        }

        int mid=start+(end-start)/2;

        TreeNode curr=new TreeNode(list.get(mid));

        curr.left=buildBST(start,mid-1,list);
        curr.right=buildBST(mid+1,end,list);
        

        return curr;

    }


    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();    
        inOrder(root,list);




        return buildBST(0,list.size()-1,list);        
    }
}