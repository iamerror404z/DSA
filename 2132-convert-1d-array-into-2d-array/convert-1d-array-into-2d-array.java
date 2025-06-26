class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int pos=0;
        int len=original.length;
        int[][] ans=new int[m][n];

        if((m*n)!=len){
            int[][] zero=new int[0][0];
            return zero;
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
        ans[i][j]=original[pos++];
                
                
            }
        }


        return ans;
    }
}