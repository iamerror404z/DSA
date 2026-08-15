class Solution {
    public int[][] buildPrefixSum(char[][] matrix){
        int rowSize=matrix.length;
        int colSize=matrix[0].length;

        int[][] prefixSum=new int[rowSize][colSize];

        //edge cases

        int left=0;
        for(int i=0;i<colSize;i++){
            int curr=matrix[0][i] -'0';

            prefixSum[0][i]+=curr+left;

            left+=curr;
        }

        for(int i=1;i<rowSize;i++){
            left=0;
            for(int j=0;j<colSize;j++){
                int curr=matrix[i][j]-'0';

                int upper=prefixSum[i-1][j];
                prefixSum[i][j]=upper+left+curr;

                left+=curr;            
            }
        }



        return prefixSum;
    }


    public int biSearch(int r,int c,int[][] prefixSum,int size){

        int start=0;
        int end=size;
        int max=0;

        while(start<=end){
            int mid=start+(end-start)/2;

            int area=prefixSum[r+mid][c+mid];

            int upper=r-1>=0?prefixSum[r-1][c+mid]:0;
            int left=c-1>=0?prefixSum[r+mid][c-1]:0;
           

            if(r>=1 && c-1>=0){
                left=left-prefixSum[r-1][c-1];
            }

            
            int expected=(mid+1)*(mid+1);
        
            area=area-(left+upper);

            if(area==expected){
                max=mid+1;
              
                start=mid+1;
            }else{
                end=mid-1;
            }

            

        }

        return max;
    }


    public int maximalSquare(char[][] matrix) {
        int rowSize=matrix.length;
        int colSize=matrix[0].length;

        int[][] prefixSum=buildPrefixSum(matrix);
        
        // for(int i[]:prefixSum){
        //     System.out.println(Arrays.toString(i));
        // }

        int max=0;

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                int curr=matrix[i][j]-'0';

                if(curr==0){
                    continue;
                }

                int right=colSize-1-j;
                int down=rowSize-1-i;

                int end=Math.min(right,down);
                int start=0;

                int maxSize=biSearch( i, j,prefixSum,end);

                // System.out.println("biSearch is : "+maxSize+"\n");
                // System.out.println("index i is : "+i+" index j is "+j);

                max=Math.max(max,maxSize);
            }
        }


        if(colSize>=2){
        int test=biSearch(0,1,prefixSum,0);
        System.out.println("biSearch is : "+test);
        // System.out.println("sum is L "+prefixSum[1+1][2+1]);
        }

        return max*max;

    }
}