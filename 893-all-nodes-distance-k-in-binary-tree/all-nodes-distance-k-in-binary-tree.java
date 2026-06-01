/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int dfs(TreeNode curr,int currLevel,int target,int targetLevel,List<Integer> list){
        if(curr==null || currLevel>targetLevel){
            return 0;
        }

        int newCurrLevel=currLevel;

        if(curr.val==target || currLevel!=0){
            newCurrLevel=currLevel+1;
        }



        int left=dfs(curr.left,newCurrLevel,target,targetLevel,list);
        int right=dfs(curr.right,newCurrLevel,target,targetLevel,list);


        if(currLevel==targetLevel){
            list.add(curr.val);
        }else if(newCurrLevel==0 && (left==targetLevel || right==targetLevel)){
            list.add(curr.val);
        }


        if(left!=0 && newCurrLevel==0){
            newCurrLevel=left+1;
            dfs(curr.right,left+1,target,targetLevel,list);
        }else if(right!=0 && newCurrLevel==0){
            newCurrLevel=right+1;
            dfs(curr.left,right+1,target,targetLevel,list);
        }


        return newCurrLevel;
    }




    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list=new LinkedList<>();
        if(k==0){
            list.add(target.val);
            return list;
        }

        
        dfs(root,0,target.val,k,list);



        return list;
    }
}