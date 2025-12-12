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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(queue.size()!=0){
            int size=queue.size();
            for(int i=0;i<size-1;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null){
                    queue.offer(curr.left);
                }if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }

            TreeNode last=queue.poll();
         
            if(last.left!=null){
                queue.offer(last.left);
            }if(last.right!=null){
                queue.offer(last.right);
            }
            list.add(last.val);
        }



        return list;
    }
}