class Solution {

    public int dp(int index,int[] memo,int[] costs){
        if(index>=memo.length){
            
            return 0;
        }

        if(memo[index]!=-1){
            return memo[index];
        }

        int min=Integer.MAX_VALUE;
        for(int i=index+1;i<=Math.min(index+3,costs.length);i++){
            int s=i-index;

            int curr=dp(i,memo,costs)+costs[i-1]+(s*s);
            min=Math.min(min,curr);
        }



        return memo[index]=min;
    }


    public int climbStairs(int n, int[] costs) {
        int length=costs.length;
        int[] memo=new int[n];
        Arrays.fill(memo,-1);


        
        return dp(0,memo,costs);
    }
}