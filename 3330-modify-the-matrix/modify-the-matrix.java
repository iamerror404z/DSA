class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
    int[] max=new int [col];
    for(int i=0;i<col;i++){
         int maxc=matrix[0][i];
        for(int j=0;j<row;j++){
            if(matrix[j][i]>maxc){
                maxc=matrix[j][i];}
        }
        max[i]=maxc;
    }
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(matrix[i][j]==-1){
                matrix[i][j]=max[j];
            }
        }
    }


    return matrix;    
    }
}