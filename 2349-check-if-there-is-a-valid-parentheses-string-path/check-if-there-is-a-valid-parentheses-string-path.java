class Solution {
    public int dp(int r,int c,int openBracket,int[][][] memo,char[][] grid){
        int rowSize=grid.length;
        int colSize=grid[0].length;
        
        
        if(r>=rowSize || c>=colSize){

            return -1;
        }
        
        char curr=grid[r][c];

        if(openBracket==0 && curr==')'){

            memo[r][c][0]=-1;
            return -1;
        }

        
        int next=openBracket;

        if(curr=='('){
            next++;
        }else{
            next--;
        }


        if(r==rowSize-1 && c==colSize-1 && next==0){

            memo[r][c][1]=1;
            return 1;
        }


        if(memo[r][c][openBracket]!=0){
            return memo[r][c][openBracket];
        }

        int right=dp(r,c+1,next,memo,grid);
        int down=dp(r+1,c,next,memo,grid);
        memo[r][c][openBracket]=Math.max(right,down);



        return memo[r][c][openBracket];
    }



    public boolean hasValidPath(char[][] grid) {
        int rowSize=grid.length;
        int colSize=grid[0].length;
        
        int[][][] memo = new int[rowSize][colSize][rowSize+colSize];

        
        int res=dp(0,0,0,memo,grid);




       
        return res==1;   
    }
}