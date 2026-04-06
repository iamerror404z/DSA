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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        
        deque.add(root);

        int ans=0;

        while(deque.size()!=0){
            int size=deque.size();
            TreeNode curr=deque.poll();
            ans=curr.val;

            if(curr.left!=null){
                deque.add(curr.left);
            }

            if(curr.right!=null){
                deque.add(curr.right);
            }

            for(int i=1;i<size;i++){
                curr=deque.poll();

                if(curr.left!=null){
                    deque.add(curr.left);
                }

                if(curr.right!=null){
                    deque.add(curr.right);
                }            
            }
            
        }




        return ans;
    }
}