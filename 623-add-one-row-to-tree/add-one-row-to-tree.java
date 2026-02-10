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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode ans=new TreeNode(val);
            ans.left=root;


            return ans;

        }

        Queue<TreeNode> queue=new LinkedList<>();

        int level=1;
        queue.add(root);

        while(level!=depth-1){
            int size=queue.size();

            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }


            level++;
        }
        
        int size=queue.size();

        
        for(int i=0;i<size;i++){
            TreeNode curr=queue.poll();
            TreeNode tempLeft=curr.left;
            TreeNode tempRight=curr.right;
            
            curr.left=new TreeNode(val);
            curr.left.left=tempLeft;

            curr.right=new TreeNode(val);
            curr.right.right=tempRight;

            

        }


        


        return root;
    }
}