class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rowSize=matrix.length;
        int colSize=matrix[0].length;

        int[][] backtracking=new int[rowSize][colSize];

        for(int i=0;i<colSize;i++){
                backtracking[rowSize-1][i]=matrix[rowSize-1][i];
            }
        

        for(int i=rowSize-2;i>=0;i--){
            for(int j=colSize-1;j>=0;j--){
                int down=backtracking[i+1][j];
                int left=down,right=down;
                if(j+1<colSize){
                    right=backtracking[i+1][j+1];
                }
                if(j-1>=0){
                    left=left=backtracking[i+1][j-1];
                }

                int min=Math.min(left,right);
                min=Math.min(min,down);

                backtracking[i][j]=min+matrix[i][j];
            }



            
        }


        

        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<colSize;i++){
            min=Math.min(min,backtracking[0][i]);
        }



        
        

        return min;    
        
        }
}