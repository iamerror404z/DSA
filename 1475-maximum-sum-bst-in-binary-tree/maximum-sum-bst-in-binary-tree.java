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
    public int[] maxBST(TreeNode curr,int[] res){
        if(curr.left==null && curr.right==null){
            
            res[0]=Math.max(res[0],curr.val);

            return new int[]{curr.val,curr.val,1,curr.val};
        }else if(curr.left!=null && curr.right==null){
            int[] left=maxBST(curr.left,res);

            if(left[2]==-1 || curr.val<=left[1]){
                
                left[2]=-1;
                return left;
            }

           left[1]=curr.val;
           left[3]+=curr.val;

            res[0]=Math.max(res[0],left[3]);
            return left;
        }else if(curr.left==null && curr.right!=null){
            int[] right=maxBST(curr.right,res);

            if(right[2]==-1 || right[0]<=curr.val){

                right[2]=-1;
                return right;
            }

            right[0]=curr.val;
            right[3]+=curr.val;

            res[0]=Math.max(res[0],right[3]);
            return right;
        }

        int[] left=maxBST(curr.left,res);
        int[] right=maxBST(curr.right,res);

        if(left[2]==-1 || right[2]==-1){
            left[2]=-1;
            return left;
        }

        if(curr.val<=left[1] || curr.val>=right[0]){

            left[2]=-1;
            return left;
        }

        
        left[1]=right[1];
        left[3]+=curr.val+right[3];
        res[0]=Math.max(res[0],left[3]);


        return left;
    }


    public int maxSumBST(TreeNode root) {
        int[] res=new int[1];
        
        maxBST(root,res);
        return res[0];
    }
}