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
    
    public void depth(TreeNode curr,int[] depth,int level){
        if(curr==null){
            depth[0]=Math.max(depth[0],level);
            return;
        }

        depth(curr.left,depth,level+1);
        depth(curr.right,depth,level+1);

    } 


    public void depth(TreeNode curr,int level,int[][] track){
        if(curr==null){
            return;
        }

        track[level][1]+=curr.val;

        depth(curr.left,level+1,track);
        depth(curr.right,level+1,track);
    }

    public int maxLevelSum(TreeNode root) {
        int[] depth=new int[1];
        depth(root,depth,0);
       
        int[][] track=new int[depth[0]][2];

        depth(root,0,track);
        int max=Integer.MIN_VALUE;

        for(int[] i:track){
            if(i[1]>max){
                max=i[1];
            }
        }

        for(int i=0;i<depth[0];i++){
            if(track[i][1]==max){
                return i+1;
            }
        }

        return 0;
    }
}