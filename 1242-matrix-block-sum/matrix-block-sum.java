class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rowSize=mat.length;
        int colSize=mat[0].length;
        int[][] window=new int[rowSize][colSize];
        
        window[0][0]=mat[0][0];

        for(int i=1;i<colSize;i++){
            window[0][i]=mat[0][i]+window[0][i-1];
        }

        for(int i=1;i<rowSize;i++){
            window[i][0]=mat[i][0]+window[i-1][0];
            for(int j=1;j<colSize;j++){
                window[i][j]=mat[i][j]+window[i][j-1]+window[i-1][j]-window[i-1][j-1]; 
            }
        }


        for(int i[]:window){
            System.out.println(Arrays.toString(i));
        }

        int[][] ans=new int[rowSize][colSize];

        
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                int rowEnd=Math.min(i+k,rowSize-1);
                int colEnd=Math.min(j+k,colSize-1);
                int rowStart=Math.max(0,i-k);
                int colStart=Math.max(0,j-k);
                int value=window[rowEnd][colEnd];

                int top=0;
                int left=0;

                

                if(colStart>0){
                    left=window[rowEnd][colStart-1];
                }

                if(rowStart>0){
                    int edge=0;
                    top=window[rowStart-1][colEnd];

                    if(colStart>0){
                        edge=window[rowStart-1][colStart-1];
                    }
                    top-=edge;
                }
                


                ans[i][j]=value-left-top;

            }
        }

        


        return ans;
    }
}