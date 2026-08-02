class Solution {

    public int maxDiff(int start,int end,int[] piles,int[][] memo){
        if(start>end){
            return 0;
        }

        if(memo[start][end]!=Integer.MIN_VALUE){
            return memo[start][end];
        }
        
        int leftMaxDiff=piles[start]-maxDiff(start+1,end,piles,memo);
        int rightMaxDiff=piles[end]-maxDiff(start,end-1,piles,memo);
        memo[start][end]=Math.max(leftMaxDiff,rightMaxDiff);



        return memo[start][end];

    }



    public boolean stoneGame(int[] piles) {
        int length=piles.length;
        int[][] memo=new int[length][length];


        for(int i[]:memo){
            Arrays.fill(i,Integer.MIN_VALUE);
        }
        

        return maxDiff(0,length-1,piles,memo)>=1; 
    }
}