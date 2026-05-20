class Solution {

    public int countPaths(int index,int target,int nums[],int[][] dp){
        if(index>nums.length || target>dp[0].length){
            return 0;
        }

        if(index==nums.length){
            if(target==0){
                return 1;
            }


            return 0;
        }


       
        if(dp[index][target]!=-1){
            return dp[index][target];
        }

        int posCount=countPaths(index+1,Math.abs(target-nums[index]),nums,dp);

        
        int negCount=countPaths(index+1,Math.abs(target+nums[index]),nums,dp);


        dp[index][target]=posCount+negCount;



        return dp[index][target];

    }



    public int findTargetSumWays(int[] nums, int target) {
        int size=nums.length;
        int sum=0;

        for(int i=0;i<size;i++){
            nums[i]=Math.abs(nums[i]);
            sum+=nums[i];
        }
        
        if(sum<target){
            return 0;
        }

        int[][] dp=new int[size][Math.abs(target)+sum+1];

        for(int i[]:dp){
            Arrays.fill(i,-1);
        }



        int ans=countPaths(0,Math.abs(target),nums,dp);

        return ans;
        
    }
}