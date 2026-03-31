class Solution {

    public int recursion(int num,int[] dp){
        if(num<=1){
            return 1;
        }

        if(dp[num]!=-1){
            return dp[num];
        }

        dp[num]=recursion(num-1,dp)+recursion(num-2,dp);


        return dp[num];
    }

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return recursion(n,dp);
    }
}