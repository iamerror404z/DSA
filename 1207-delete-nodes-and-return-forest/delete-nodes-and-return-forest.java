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
    public TreeNode dfs(TreeNode curr,int[] map,List<TreeNode>  list,boolean isRoot){
        if(curr==null){
            return null;
        }

        int currValue=curr.val;

        if(currValue==6){
            System.out.println(isRoot);
        }

        // System.out.println(currValue);

        if(isRoot && (currValue>=map.length || map[currValue]==0)){
            list.add(curr);
        }


        boolean newIsRoot=false;


        if(currValue<map.length && map[currValue]!=0){
    
            newIsRoot=true;
        }

        TreeNode left=dfs(curr.left,map,list,newIsRoot);
        TreeNode right=dfs(curr.right,map,list,newIsRoot);


        curr.left=left;
        curr.right=right;



        if(currValue<map.length && map[currValue]!=0){
            curr=null;
            return null;
        }


        return curr;

    }




    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int max=0;
        for(int i:to_delete){
            max=Math.max(i,max);
        }



        int[] map=new int[max+1];

        for(int i:to_delete){
            map[i]=1;
        }






        List<TreeNode> list=new LinkedList<>();
        dfs(root,map,list,true);








        return list;
        
    }
}