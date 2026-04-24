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
    public long Sum(TreeNode curr){
        if(curr==null){

            return 0;
        }


        return curr.val+Sum(curr.left)+Sum(curr.right);
    }

    public long  maxProduct(TreeNode curr,long[] max,long sum){
        if(curr==null){
            return 0;
        }

        long left=maxProduct(curr.left,max,sum);
        long right=maxProduct(curr.right,max,sum);

        long part1=left+right+curr.val;
        long part2=sum-part1;

        max[0]=Math.max(max[0],part1*part2);


        return part1;


    }


    public int maxProduct(TreeNode root) {
        int modulo=(int)Math.pow(10,9)+7;

        long []max=new long[1];
        
        long sum=Sum(root);
        maxProduct(root,max,sum);


        return (int)(max[0]%modulo);
        
    }
}