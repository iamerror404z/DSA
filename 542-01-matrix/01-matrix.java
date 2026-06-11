class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue=new LinkedList<>();
        int rowSize=mat.length;
        int colSize=mat[0].length;
        int[][] visited=new int[rowSize][colSize];
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
                
                if(curr==0){
                    visited[i][j]=1;
                }
                
                min=Math.min(min,Math.min(left,right));

                if(min==0 && curr==1){


                    queue.add(new int[]{i,j});
                }
            }
        }










        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int row=curr[0];
            int col=curr[1];

            if(visited[row][col]==1){
                continue;
            }

            
            visited[row][col]=1;

            
            int max=Integer.MAX_VALUE-10;
            int min=max;
            int up=max,down=max,left=max,right=max;

            if(row-1>=0){
                if(visited[row-1][col]==0){
                    queue.add(new int[]{row-1,col});
                }else{
                    min=res[row-1][col];
                    up=min;
                }
            }
            if(row+1<rowSize){
                if(visited[row+1][col]==0){
                    queue.add(new int[]{row+1,col});
                }else{
                    min=Math.min(min,res[row+1][col]);
                    down=res[row+1][col];
                }
            }

            if(col-1>=0){
                if(visited[row][col-1]==0){
                    queue.add(new int[]{row,col-1});
                }else{
                    min=Math.min(min,res[row][col-1]);
                    left=res[row][col-1];
                }
            }


            if(col+1<colSize){
                if(visited[row][col+1]==0){
                    queue.add(new int[]{row,col+1});
                }else{
                    min=Math.min(min,res[row][col+1]);
                    right=res[row][col+1];
                }
            }


            

            res[row][col]=min+1;



        }








        return res;
    }

}


    