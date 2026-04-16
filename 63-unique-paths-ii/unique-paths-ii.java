class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;

        int[][] backTrack=new int[row][col];

        if(obstacleGrid[row-1][col-1]!=1){
            backTrack[row-1][col-1]=1;
        }

        for(int i=col-2;i>=0;i--){
            backTrack[row-1][i]=backTrack[row-1][i+1];
            if(obstacleGrid[row-1][i]==1){
                backTrack[row-1][i]=0;
            }
        }
        
        for(int i=row-2;i>=0;i--){
            if(obstacleGrid[i][col-1]!=1){
                backTrack[i][col-1]=backTrack[i+1][col-1];
            }

            for(int j=col-2;j>=0;j--){
                if(obstacleGrid[i][j]!=1){
                    backTrack[i][j]=backTrack[i+1][j]+backTrack[i][j+1];
                }
            }

        }

        

        return backTrack[0][0];
    }
}