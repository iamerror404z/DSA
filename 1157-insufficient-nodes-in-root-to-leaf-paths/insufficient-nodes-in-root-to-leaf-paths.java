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
    

    public long[] dfs(TreeNode curr,int limit,long runSum){
        long[] res=new long[3];

       if(curr==null){
        return res;
       }

       long max=Long.MIN_VALUE;
       boolean notFlag=true;

       long[] left=dfs(curr.left,limit,runSum+curr.val);
       long[] right=dfs(curr.right,limit,runSum+curr.val);

       if(left[1]==1){
        curr.left=null;
       }

       if(left[1]!=0){
        notFlag=false;
        max=Math.max(max,left[0]);
       }


       if(right[1]==1){
        curr.right=null;
       }

       

       if(right[1]!=0){
        notFlag=false;
        max=Math.max(max,right[0]);
       }


       if(notFlag){
        max=0;
       }


       max+=curr.val+runSum;

       if(max<limit){
        res[1]=1;
       }else{
        res[1]=2;
       }
       
       res[0]=max-runSum;


      
      return res;
    }



    public TreeNode sufficientSubset(TreeNode root, int limit) {
       long[] res=dfs(root,limit,0);

       if(res[1]==1){
        return null;
       }




        return root;
    }
}