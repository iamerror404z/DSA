class Solution {
    public void setZeroes(int[][] matrix) {
        LinkedHashSet<Integer> row=new LinkedHashSet<>();
        LinkedHashSet<Integer> col=new LinkedHashSet<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int r:row){
            for(int step=0;step<n;step++){
                matrix[r][step]=0;
            }
        }
        for(int c:col){
            for(int step=0;step<m;step++){
                matrix[step][c]=0;
            }
        }
    }
}