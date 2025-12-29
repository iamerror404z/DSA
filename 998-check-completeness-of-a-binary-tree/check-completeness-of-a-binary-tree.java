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

    public  void findDepth(TreeNode curr,int level,int[] depth){
        if(curr==null){
            return;
        }
        findDepth(curr.left,level+1,depth);
        findDepth(curr.right,level+1,depth);

        depth[0]=Math.max(depth[0],level);
    }

    

    public boolean isCompleteTree(TreeNode root) {
        int[] depth=new int[1];
        findDepth(root,0,depth);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        for(int i=0;i<=depth[0]-2;i++){
            int size=queue.size();
            for(int j=0;j<size;j++){
                TreeNode curr=queue.poll();
                if(curr.left!=null && curr.right!=null){
                    queue.add(curr.left);
                    queue.add(curr.right);
                }else{
                    return false;
                }
            }
        }

        
        int size=queue.size();
        int nullLoc=(2*size)+1;
        int valueLoc=0;

        

        for(int i=0;i<size;i++){
            TreeNode curr=queue.poll();
            int left=2*i;
            int right=left+1;
            if(curr.left!=null){
                valueLoc=Math.max(valueLoc,left);
            }else{
                nullLoc=Math.min(nullLoc,left);
            }

            if(curr.right!=null){
                valueLoc=Math.max(valueLoc,right);
            }else{
                nullLoc=Math.min(nullLoc,right);
            }

        }
        

        return nullLoc>=valueLoc;
    }
}