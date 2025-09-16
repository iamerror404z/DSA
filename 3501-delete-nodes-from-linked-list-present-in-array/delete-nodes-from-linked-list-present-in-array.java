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
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer,Integer> hm=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],1);
        }

        ListNode curr=head;


        while(curr!=null && hm.keySet().contains(curr.val)){
            curr=curr.next;
        }
        
        if(curr==null){
            return null;
        }

        ListNode  nhead=curr;

        ListNode prev=curr;
        ListNode next=null;
        curr=curr.next;

        while(curr!=null){
            int key=hm.getOrDefault(curr.val,0);
            if(key==1){
                prev.next=curr.next;
                curr=curr.next;
            }else{
                prev=curr;
                curr=curr.next;}
        }

        


        return nhead;
        
    }
}