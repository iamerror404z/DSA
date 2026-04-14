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

    public int[] dfs(TreeNode curr,int start,int edges,int[] max){
        int[] res=new int[2];

        if(curr==null){
            res[0]=-1;
            res[1]=-1;

            return res;
        }

        int[] left=dfs(curr.left,start,edges+1,max);
        int[] right=dfs(curr.right,start,edges+1,max);

        res[0]=Math.max(left[0]+1,right[0]+1);
        res[1]=Math.max(left[1],right[1]);



        if(curr.val==start){
            res[1]=edges;
            max[0]=Math.max(max[0],Math.max(left[0]+1,right[0]+1));

            return res;
        }else if(left[1]!=-1){
            int time=(left[1]-edges)+right[0]+1;
            max[0]=Math.max(time,max[0]);


            return res;

        }else if(right[1]!=-1){
            int time=(right[1]-edges)+left[0]+1;
            max[0]=Math.max(time,max[0]);
           

            return res;
        }
        




        return res;
    }


    public int amountOfTime(TreeNode root, int start) {
        int[] max=new int[1];
        dfs(root,start,0,max);


        return max[0];
    }
}