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

    public void findDepth(TreeNode curr,int level,int levelSum,int sum,int depth[],int size[]){
        if(curr==null){
            depth[0]=Math.max(depth[0],level);
            return;
        }

        if(curr.left==null && curr.right==null){
            size[0]=Math.max(size[0],sum);
        }
        
        level++;
        levelSum*=2;
        sum+=levelSum;
        findDepth(curr.left,level,levelSum,sum,depth,size);
        findDepth(curr.right,level,levelSum,sum,depth,size);

    }

    public void traverse(TreeNode curr,int start,int end,int row,List<List<String>>  list){
        if(curr==null){
            return;
        }

        int mid=start+(end-start)/2;
        list.get(row).set(mid,""+curr.val);
        

        row++;
        traverse(curr.left,start,mid-1,row,list);
        traverse(curr.right,mid+1,end,row,list);

    }


    public List<List<String>> printTree(TreeNode root) {
        int[] depth=new int[1];
        int[] size=new int[1];

        findDepth(root,0,1,1,depth,size);
        // System.out.println("The size is : "+size[0]);
        // System.out.println("The depth is : "+depth[0]);
        List<List<String>> wrapped=new LinkedList<>();

        List<String> inner=new LinkedList<>(Collections.nCopies(size[0],""));
        wrapped.add(inner); 

        for(int i=1;i<depth[0];i++){
            List<String> temp=new LinkedList<>(inner);
            wrapped.add(temp);
        }


        traverse(root,0,size[0]-1,0,wrapped);


        // System.out.println(wrapped);



        return wrapped;
    }   
}