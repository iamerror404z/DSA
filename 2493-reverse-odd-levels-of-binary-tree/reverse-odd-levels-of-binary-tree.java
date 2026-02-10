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
    public void helper(Deque<TreeNode> queue){
        Queue<TreeNode> first=new LinkedList<>();
        Stack<TreeNode> second=new Stack<>();
        int mid=queue.size()/2;

        while(queue.size()!=0){
            TreeNode front=queue.pollFirst();
            TreeNode end=queue.pollLast();
            int temp=front.val;
            front.val=end.val;
            end.val=temp;

            first.add(front);
            second.add(end);
        }

        while(first.size()!=0){
            TreeNode curr1=first.poll();
            TreeNode curr2=second.pop();

            if(curr1.left!=null){
                queue.addLast(curr1.left);
                queue.addLast(curr1.right);
                queue.addLast(curr2.left);
                queue.addLast(curr2.right);
            }

        }



    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode>    queue=new LinkedList<>();
        queue.addLast(root);
        int level=0;

        while(queue.size()!=0){
            if(level%2!=0){
                helper(queue);

            }else{
                int size=queue.size();
                for(int i=0;i<size;i++){
                    TreeNode curr=queue.pollFirst();
                    if(curr.left!=null){
                        queue.addLast(curr.left);
                        queue.addLast(curr.right);
                    }
                }
            }

            level++;
        }



        
        return root;
    }
}