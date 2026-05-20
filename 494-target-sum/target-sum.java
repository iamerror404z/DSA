class Solution {

    public int countPaths(int index,int target,int nums[],int[][] dp){
        if(index==nums.length){
            if(target==0){
                return 1;
            }


            return 0;
        }

        int posCount=countPaths(index+1,Math.abs(target-nums[index]),nums,dp);

        
        int negCount=countPaths(index+1,Math.abs(target+nums[index]),nums,dp);


        int res=posCount+negCount;



        return res;

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

        int[][] dp=new int[size][sum+1];



        int ans=countPaths(0,target,nums,dp);
        System.out.println(ans);

        return ans;
        
    }
}