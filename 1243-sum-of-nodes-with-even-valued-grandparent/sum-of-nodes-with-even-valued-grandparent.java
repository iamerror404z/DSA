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
    // public void recursion(TreeNode curr,int pass1,int pass2,int level,int[] even){
    //     if(curr==null){
    //         return ;
    //     }

    //     if(level==pass1){
    //         even[0]+=curr.val;

    //         pass1=-1;
    //     }

    //     if(level==pass2)
        

    // }

    public int[] recursion(TreeNode curr,int []even){
        int[] ans=new int[2];
        if(curr==null){
            return ans;
        }
    
        int[] left=recursion(curr.left,even);
        int[] right=recursion(curr.right,even);

        if(curr.val%2==0){
            even[0]+=(left[1]+right[1]);
        }
        
        ans[1]=left[0]+right[0];
        ans[0]+=curr.val;

        



        return ans;
    }

    public int sumEvenGrandparent(TreeNode root) {
        int[] evenSum=new int[1];
        int []level=new int[1];
        
        recursion(root,evenSum);

        // System.out.println(Arrays.toString(recursion(root)));
        return evenSum[0];
    }
}