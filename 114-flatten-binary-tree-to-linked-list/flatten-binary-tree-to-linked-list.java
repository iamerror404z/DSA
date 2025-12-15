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

    public TreeNode[] backTracking(TreeNode curr){
        
    TreeNode[] res=new TreeNode[2];
    if(curr==null){

        return res;
    }
    
    TreeNode[] left=backTracking(curr.left);
    TreeNode[] right=backTracking(curr.right);
    
    
    if(left[0]==null && right[1]==null){
        res[0]=curr;
        res[1]=curr;
        return res;
    }

    if(left[0]!=null){
        curr.right=left[0];
        left[1].right=right[0];
        res[0]=curr;
        
    }else{
        curr.right=right[0];
        res[0]=curr;
    }
    

    if(right[1]!=null){
        res[1]=right[1];
    }else{
        res[1]=left[1];
    }

    curr.left=null;


    return res;

    
    }

    public void flatten(TreeNode root) {
    //    Queue<TreeNode> queue=new LinkedList<>();

        backTracking(root);

       return ; 
    }
}