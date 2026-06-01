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
    public int depthSize(TreeNode curr,int level){
        if(curr==null){
            return level;
        }

        int left=depthSize(curr.left,level+1);
        int right=depthSize(curr.right,level+1);


        return Math.max(left,right);
    }

    public void sum(TreeNode curr,int level,int[] map){
        if(curr==null){
            return;
        }

        map[level]+=curr.val;

        sum(curr.left,level+1,map);
        sum(curr.right,level+1,map);
    }


    public void updateRaid(TreeNode curr,int level,int[] map){
        if(curr==null){
            return ;
        }

        int nextSum=map[level+1];

        int childNodes=(curr.left!=null?curr.left.val:0)+(curr.right!=null?curr.right.val:0);
        nextSum-=childNodes;

        if(curr.left!=null){
            curr.left.val=nextSum;
        }

        if(curr.right!=null){
            curr.right.val=nextSum;
        }



        updateRaid(curr.left,level+1,map);
        updateRaid(curr.right,level+1,map);


    }



    public TreeNode replaceValueInTree(TreeNode root) {
       int size=depthSize(root,0);
       System.out.println(size);
       int[] map=new int[size+1];

       sum(root,0,map);
       updateRaid(root,0,map);
       root.val=0;



        return root;
    }
}