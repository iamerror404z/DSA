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
    int max=0;

    public int maxFreq(TreeNode curr,Map<Integer,Integer> map){
        if(curr==null){
            return 0;
        }

        int left=maxFreq(curr.left,map);
        int right=maxFreq(curr.right,map);
        int sum=left+right+curr.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        max=Math.max(map.get(sum),max);

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        maxFreq(root,map);
        int count=0;

        for(int i:map.keySet()){
            if(map.get(i)==max){
                count++;
            }
        }
        int[] ans=new int[count];
        int pos=0;

        for(int i:map.keySet()){
            if(map.get(i)==max){
                ans[pos++]=i;
            }
        }

        return   ans;   
    }
}