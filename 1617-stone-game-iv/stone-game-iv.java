class Solution {

    public int dp(int n,int[] dp){
        if(n<=0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int win=0;

        for(int i=1;i*i<=n;i++){
            int nextPlayer=dp(n-(i*i),dp);
            
            int currPlayer=1^nextPlayer;

            if(currPlayer==1){
                dp[n]=1;
                return 1;
            }


        }



        return win;
    }



    public boolean winnerSquareGame(int n) {
        int[] memo=new int[n+1];

       Arrays.fill(memo,-1);

        


        return dp(n,memo)==1;
    }
}