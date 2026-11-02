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
    
    public ListNode findMidNode(ListNode root){
        ListNode prev=null,slow=root,fast=root;

        while(fast!=null && fast.next!=null){
            prev=slow;

            slow=slow.next;
            fast=fast.next.next;
        }

        


        return prev;
    }   
    

    public TreeNode listToBST(ListNode list){
        if(list==null){
            return null;
        }

        if(list.next==null){
            return new TreeNode(list.val);
        }

        ListNode part1Tail=findMidNode(list);
        
        ListNode mid=part1Tail.next;
        

        ListNode part2Head=mid.next;

        part1Tail.next=null;
        mid.next=null;



        TreeNode curr = new TreeNode(mid.val);
        curr.left=listToBST(list);
        curr.right=listToBST(part2Head);

        
        return curr;
    }



    public TreeNode sortedListToBST(ListNode head) {




     return listToBST(head);   
    }
}