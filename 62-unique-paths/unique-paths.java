class Solution {
    public int uniquePaths(int m, int n) {
        int row=m;
        int col=n;
        int[][] backTrack=new int[row][col];

        for(int i=col-1;i>=0;i--){
            backTrack[row-1][i]=1;
        }

        for(int i=row-2;i>=0;i--){
            backTrack[i][col-1]=1;

            for(int j=col-2;j>=0;j--){
                backTrack[i][j]=backTrack[i][j+1]+backTrack[i+1][j];
            }
        }

        



        return backTrack[0][0];
        
    }
}