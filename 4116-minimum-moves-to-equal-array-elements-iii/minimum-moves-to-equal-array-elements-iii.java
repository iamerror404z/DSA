class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];

        for(int i:nums){
            max=Math.max(max,i);
        }
        int res=0;

        for(int num:nums){
            res+=max-num;
        }


        return res;
    }
}