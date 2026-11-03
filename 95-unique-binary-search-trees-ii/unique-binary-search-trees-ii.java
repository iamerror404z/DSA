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


class MemoNode{
    Queue<TreeNode> queue;

    MemoNode(Queue<TreeNode> queue){
        this.queue=queue;
        
    }

}

class Solution {

    public Queue<TreeNode> buildTrees(int left,int right,MemoNode[][] memo){
        if(left==right){
            Queue<TreeNode> trees=new LinkedList<>();
            trees.add(new TreeNode(left));

            return trees;
        }

        if(left>right){
            
        Queue<TreeNode> trees=new LinkedList<>();
        trees.offer(null);

        return trees;
        }

        Queue<TreeNode> trees=new LinkedList<>();
        for(int i=left;i<=right;i++){
                int currPos=i;

                Queue<TreeNode> leftTrees=buildTrees(left,currPos-1,memo);
                Queue<TreeNode> rightTrees=buildTrees(currPos+1,right,memo);

                
                
                for(TreeNode leftRoot:leftTrees){
                    for(TreeNode rightRoot:rightTrees){

                        trees.offer(new TreeNode(currPos,leftRoot,rightRoot));
                    }
                }

        }



        memo[left][right].queue=trees;
        return trees;
    }



    public List<TreeNode> generateTrees(int n) {
        MemoNode[][] memo=new MemoNode[n+1][n+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                memo[i][j]=new MemoNode(new LinkedList<>());
            }
        }



        // for the final answer


        List<TreeNode> res=new ArrayList<>();
        for(TreeNode root:buildTrees(1,n,memo)){
            res.add(root);
        }


        return res;
    }
}