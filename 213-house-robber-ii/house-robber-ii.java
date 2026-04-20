class Solution {
    public int rob(int[] nums) {
        int max=0;
        int oneStepAway=0;
        int twoStepAway=0;
        int threeStepAway=0;
        int length=nums.length;
        int start=0;
        int end=length-1;

        // for(int i=end-2;i>0;i--){

        // }


        for(int i=end-1;i>=0;i--){
            int currSum=nums[i]+Math.max(twoStepAway,threeStepAway);

            max=Math.max(currSum,max);

            threeStepAway=twoStepAway;
            twoStepAway=oneStepAway;
            oneStepAway=currSum;    
        }

        oneStepAway=0;
        twoStepAway=0;
        threeStepAway=0;

        for(int i=end-2;i>=0;i--){
            int currSum=nums[i]+Math.max(twoStepAway,threeStepAway);

            threeStepAway=twoStepAway;
            twoStepAway=oneStepAway;
            oneStepAway=currSum;

            max=Math.max(max,currSum);
        }

        int tail=nums[end]+Math.max(twoStepAway,threeStepAway);

        max=Math.max(max,tail);



            return max;
    }
}