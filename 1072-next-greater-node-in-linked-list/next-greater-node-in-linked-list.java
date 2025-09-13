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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> lst=new ArrayList<>();
        int len=0;
        ListNode curr=head;
        while(curr!=null){
            len++;
            lst.add(curr.val);
            curr=curr.next;
        }
        int[] ans=new int[len];
        int max=0;
        
        int[] greatest=new int[len];

        greatest[len-1]=lst.get(len-1);

        for(int i=lst.size()-2;i>=0;i--){
            greatest[i]=Math.max(lst.get(i),greatest[i+1]);
        }

        for(int i=lst.size()-2;i>=0;i--){
            if(greatest[i]<=lst.get(i)){
                ans[i]=0;
            }else{
                for(int j=i+1;j<lst.size();j++){
                    if(lst.get(j)>lst.get(i)){
                        ans[i]=lst.get(j);
                        break;
                    }
                }
            }
        }



        return ans;
        
    }
}