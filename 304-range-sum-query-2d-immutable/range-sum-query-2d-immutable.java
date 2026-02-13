class NumMatrix {
    int[][] forward;

    public NumMatrix(int[][] matrix) {
        int rowSize=matrix.length;
        int colSize=matrix[0].length;
        forward=new int[rowSize][colSize];

        forward[0][0]=matrix[0][0];

        for(int i=1;i<colSize;i++){
            forward[0][i]=matrix[0][i]+forward[0][i-1];
        }



        for(int i=1;i<rowSize;i++){
            forward[i][0]=forward[i-1][0]+matrix[i][0];
            for(int j=1;j<colSize;j++){
                int subtract=forward[i-1][j-1];
                forward[i][j]=forward[i][j-1]+forward[i-1][j]+matrix[i][j]-subtract;
            }
        }

        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=forward[row2][col2];

        int left=0;

        if(col1>0){
            int col=col1-1;
            int row=row2;
            left=forward[row][col];
        }


        int top=0;

        if(row1>0){
            int row=row1-1;
            top=forward[row][col2];

            if(col1>0){
                top-=forward[row][col1-1];
            }

        }
        
        ans-=(top+left);

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */