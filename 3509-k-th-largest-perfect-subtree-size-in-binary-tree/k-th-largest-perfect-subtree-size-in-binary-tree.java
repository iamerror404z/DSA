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
    public int[] dfs(TreeNode curr,List<Integer> list){
        int[] res=new int[2];

        if(curr==null){
            res[1]=1;
            return res;
        }

        int[] left=dfs(curr.left,list);
        int[] right=dfs(curr.right,list);

        
        res[0]=left[0]+right[0]+1;

        if(left[0]==right[0] && left[1]==1 && right[1]==1){
            list.add(res[0]);
            res[1]=1;
        }else{
            res[1]=0;
        }
        
        

        return res;
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> size=new LinkedList<>();

        dfs(root,size);
        Collections.sort(size);
        
        if(size.size()<k){
            return -1;
        }


        return size.get((size.size()-1)-(k-1));

    }
}