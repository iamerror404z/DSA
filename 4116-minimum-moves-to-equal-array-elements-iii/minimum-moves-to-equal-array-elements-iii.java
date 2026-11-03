class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        long sum=0;

        for(int i:nums){
            max=Math.max(max,i);
            sum+=i;
        }
        int res=0;

        


        return (int)(max*nums.length-sum);
    }
}