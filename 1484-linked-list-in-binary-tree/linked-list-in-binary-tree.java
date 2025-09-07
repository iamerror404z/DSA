/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    List<TreeNode> poss=new ArrayList<TreeNode>();
    boolean ans=false;

    public void recc(TreeNode tree,ListNode list){
        if(tree==null || list==null){
            return;
        }
        if(tree.val==list.val && list.next==null){
            ans=true;    
            return;
        }

        if(tree.left!=null &&tree.left.val==list.next.val){
            recc(tree.left,list.next);
        }

        if(tree.right!=null && tree.right.val==list.next.val){
            recc(tree.right,list.next);
        }
    }

    public void rec(TreeNode curr,int start){
        if(curr==null){
            return;
        }
        if(curr.val==start){
            poss.add(curr);
        }
        rec(curr.left,start);
        rec(curr.right,start);
    }


    public boolean isSubPath(ListNode head, TreeNode root) {
        rec(root,head.val);
        
        for(int i=0;i<poss.size();i++){
            recc(poss.get(i),head);

            if(ans){
                break;
            }

        }

        return ans;
    }
}