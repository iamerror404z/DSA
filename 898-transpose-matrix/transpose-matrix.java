class Solution {
    public int[][] transpose(int[][] matrix) {
        int row=matrix.length;
        int pt1=0;
        int col=matrix[0].length;
        int[][] step=new int[col][row];
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                step[c][r]=matrix[r][c];
            }
        }
       return step; 
    }
}