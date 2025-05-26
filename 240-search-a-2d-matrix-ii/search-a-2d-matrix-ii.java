class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int row=matrix.length;
        // int col=matrix[0].length;

        for(int[] row:matrix){
            for(int num:row){
            if(num==target){
                return true;
            }
            else if(num>target){
                    break;
                }
        }
    }
            return false;
    }
}