class Solution {

    public int dp(int start,int m,int sum,int[] piles,int[][] memo){
        int end=start+(2*m);

        // base case
      
        if(end>=piles.length){
              int currSum=0; 
            for(int i=start;i<piles.length;i++){
                currSum+=piles[i];
            }

            return currSum;

        }

        if(memo[start][m]!=-1){
            return memo[start][m];
        }

        int currSum=0;
        int max=0;


        for(int i=start;i<end;i++){
            currSum+=piles[i];

            int player2=dp(i+1,Math.max(i-start+1,m),sum-currSum,piles,memo);
            int nextSum=sum-(currSum+player2);


            max=Math.max(max,currSum+nextSum);
        }



        memo[start][m]=max;

        return max;
    }



    public int stoneGameII(int[] piles) {
        int n=piles.length;

        int[][] memo=new int[n][n];

        for(int i[]:memo){
            Arrays.fill(i,-1);
        }
        int sum=0;

        for(int i:piles){
            sum+=i;
        }


        return dp(0,1,sum,piles,memo);
    }
}