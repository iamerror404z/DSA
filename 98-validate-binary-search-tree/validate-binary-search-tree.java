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

    List<Integer> lst=new LinkedList<Integer>();
    int step=0;
    int prev=0;
    boolean ans=true;
    
    public void inOrder(TreeNode curr){
        if(curr==null){
            return ;
        }
        inOrder(curr.left);
        if(step!=0&&prev>=curr.val){
            ans=false;
            // System.out.println(curr.val+"    "+prev);
            System.out.println(prev>curr.val);
            System.out.println(curr.val);
        }
        prev=curr.val;
        step++;
        lst.add(curr.val);
        inOrder(curr.right);
        }



    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        
        // for(int i=1;i<lst.size();i++){
        //     if(lst.get(i)<=lst.get(i-1)){
        //         return false;
        //     }
        // }
        
        return ans;
        
    }
}