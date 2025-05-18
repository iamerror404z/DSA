class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int r=0;r<n;r++){
        int front=0;
        int back=matrix[0].length-1;
        int mid=matrix[0].length/2;
        while(front<mid){
            int temp=matrix[r][front];
            matrix[r][front]=matrix[r][back];
            matrix[r][back]=temp;
            front++;
            back--;
        }
        }

        
    }
}