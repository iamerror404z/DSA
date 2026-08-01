/*
couldnt identify the correct pattern 
DP based probel not even able to identify the base case

practice more on dps!


work on this pattern

*/



class Solution {

    public int maxDiff(int[] nums,int left,int right,int[][] memo){
        if(left==right){
            return nums[left];
        }

        if(memo[left][right]!=-1){
            return memo[left][right];
        }

        int leftMaxScore=nums[left]-maxDiff(nums,left+1,right,memo);
        int rightMaxScore=nums[right]-maxDiff(nums,left,right-1,memo);
        memo[left][right]=Math.max(leftMaxScore,rightMaxScore);


        return memo[left][right];
    }


    public boolean predictTheWinner(int[] nums) {
        int length=nums.length;
        int[][] memo=new int[length][length];

        for(int i[]:memo){
            Arrays.fill(i,-1);
        }
        

        return maxDiff(nums,0,length-1,memo)>=0;
    }
}