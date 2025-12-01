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

    int level=0;
    long[][] size;

    public void depth(TreeNode curr,int Level){
        if(curr==null){
            level=Math.max(level,Level-1);
            return;
        }

        depth(curr.left,Level+1);
        depth(curr.right,Level+1);

    }


    public  void width(TreeNode curr,int level,long pos){
        if(curr==null){
            return;
        }
            
            size[level][0]=Math.min(size[level][0],pos);
            size[level][1]=Math.max(size[level][1],pos);

        

        width(curr.left,level+1,((pos-1)*2)+1);
        width(curr.right,level+1,((pos-1)*2)+2);

        

    }


    public int widthOfBinaryTree(TreeNode root) {
        depth(root ,1);
        size=new long[level][2];
        

        for(int i=0;i<level;i++){
            size[i][0]=Long.MAX_VALUE;
            size[i][1]=Long.MIN_VALUE;
        }

        

        width(root,0,1);
       
        long ans=1;

        for(long[] i:size){
            ans=Math.max(ans,i[1]-i[0]+1);
        }

        
        return (int)ans;

    }
}