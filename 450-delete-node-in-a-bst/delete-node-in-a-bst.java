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


    public TreeNode deleteFix(TreeNode curr,TreeNode insert){
        TreeNode root = curr;
        while(curr.right!=null){
            curr=curr.right;
        }
        curr.right=insert;
        
        return root;
    }

    public TreeNode deleteNode(TreeNode curr, int key) {
        if(curr==null){
            return null;
        }

        if(curr.val==key){
            if(curr.left!=null && curr.right!=null){

                return  deleteFix(curr.left,curr.right);
            }

            if(curr.left!=null){
                return curr.left;
            }

            return curr.right;
        }

        if(curr.val>key){
            curr.left=deleteNode(curr.left,key);
        }else{
            curr.right=deleteNode(curr.right,key);
        }
        

        return curr;
    }
}