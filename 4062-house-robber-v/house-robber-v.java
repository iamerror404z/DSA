class Solution {

    public long maxFinder(long currSum,int start,long[][] stepsAway){
        long maxSum=0;

        for(int i=start;i<3;i++){
            maxSum=Math.max(maxSum,stepsAway[i][0]);
        }



        for(int i=2;i>=1;i--){
            stepsAway[i][0]=stepsAway[i-1][0];
            stepsAway[i][1]=stepsAway[i-1][1];
        }



        return maxSum+currSum;
    }




    public long rob(int[] nums, int[] colors) {
    long max=0;
        
    int size=nums.length;

    long[][] stepsAway=new long[3][2];




    for(int i=size-1;i>=0;i--){
        int currColor=colors[i];
        int currMoney=nums[i];


        long currSum=0+currMoney;

        int start=0;
        
       

        if(stepsAway[0][1]==currColor){
            start=1;
        }

        long tempMax=maxFinder(currSum,start,stepsAway);

        max=Math.max(max,tempMax);

        stepsAway[0][0]=tempMax;
        stepsAway[0][1]=currColor;




    }




        return  max;
    }
}