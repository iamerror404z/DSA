/**
*Intially tried greedy approach without even understadning this is a dp prblem 
*later on only understood it is dp problem
 */

class Solution {
    public int dp(int num,int r,int c,int[][][] memo,int[][] grid){
        if(Math.min(r,c)<0){
            return 1024;
        }

        int curr=grid[r][c];
        int next=curr^num;
        if(r==0 && c==0){

            return next;
        }

        if(memo[num][r][c]!=-1){
            return memo[num][r][c];
        }


        int up=dp(next,r-1,c,memo,grid);
        int left=dp(next,r,c-1,memo,grid);



        return memo[num][r][c]=Math.min(up,left);
    }


    public int minCost(int[][] grid) {
        int rowSize=grid.length;
        int colSize=grid[0].length;

        int[][][] memo=new int[1024][rowSize][colSize];

        for(int i[][]:memo){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }

        }



        return dp(0,rowSize-1,colSize-1,memo,grid);
    }
}