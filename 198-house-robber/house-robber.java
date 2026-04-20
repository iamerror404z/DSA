class Solution {
    public int rob(int[] nums) {
        int oneStepAway=0;
        int twoStepAway=0;
        int threeStepAway=0;
        int max=0;

        for(int i=nums.length-1;i>=0;i--){
            int currSum=nums[i]+Math.max(twoStepAway,threeStepAway);
            max=Math.max(currSum,max);


            threeStepAway=twoStepAway;
            twoStepAway=oneStepAway;
            oneStepAway=currSum;

        }



            return max;
    }
}