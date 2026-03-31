class Solution {
    public int climbStairs(int n) {
        int prev1=1;
        int prev2=1;


        for(int i=n-2;i>=0;i--){
            prev2+=prev1;
            prev1=prev2-prev1;
        }


        return prev2;
    }
}