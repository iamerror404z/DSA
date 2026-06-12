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
    public TreeNode trimmer(TreeNode curr,int low,int high){
        if(curr==null){
            
            return null;
        }

        TreeNode down;

        TreeNode left=trimmer(curr.left,low,high);

        TreeNode right=trimmer(curr.right,low,high);

        if(left!=null){
            down=left;
        }else{
            down=right;
        }



        int currVal=curr.val;

        
        if(curr.val==0){
            System.out.println("curr index is : "+currVal);
        }


        if(currVal<low || currVal>high){
            return down;
        }

        curr.left=left;
        curr.right=right;

       

        down=curr;

        return down;
    }



    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode res=trimmer(root,low,high);


        return res;
    }
}