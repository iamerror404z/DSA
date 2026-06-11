class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue=new LinkedList<>();
        int rowSize=mat.length;
        int colSize=mat[0].length;
        int[][] res=new int[rowSize][colSize];
       


        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                int curr=mat[i][j];
                int max=Integer.MAX_VALUE;

                int up=(i-1)>=0?mat[i-1][j]:max;
                int down=(i+1)<rowSize?mat[i+1][j]:max;
                int min=Math.min(up,down);
                int left=(j-1)>=0?mat[i][j-1]:max;
                int right=(j+1)<colSize?mat[i][j+1]:max;
                
                
                min=Math.min(min,Math.min(left,right));

                if(min==0 && curr==1){
                    res[i][j]=1;


                    queue.add(new int[]{i,j});
                }
            }
        }


        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int row=curr[0];
            int col=curr[1];

            if(mat[row][col]==0){
                continue;
            }

            
            mat[row][col]=0;
            int max=Integer.MAX_VALUE;
            int min=max;
            int up=max,down=max,left=max,right=max;

            if(row-1>=0){
                if(mat[row-1][col]==1){
                    queue.add(new int[]{row-1,col});
                }else{
                    min=res[row-1][col];
                }
            }
            if(row+1<rowSize){
                if(mat[row+1][col]==1){
                    queue.add(new int[]{row+1,col});
                }else{
                    min=Math.min(min,res[row+1][col]);
                }
            }

            if(col-1>=0){
                if(mat[row][col-1]==1){
                    queue.add(new int[]{row,col-1});
                }else{
                    min=Math.min(min,res[row][col-1]);
                }
            }

            if(col+1<colSize){
                if(mat[row][col+1]==1){
                    queue.add(new int[]{row,col+1});
                }else{
                    min=Math.min(min,res[row][col+1]);
                }
            }

            res[row][col]=min+1;



        }

        // for(int i[]:res){
        //     System.out.println(Arrays.toString(i));
        // }





        return res;
    }

}


    