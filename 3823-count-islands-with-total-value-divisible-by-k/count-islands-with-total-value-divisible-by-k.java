class Solution {

    public boolean isValid(int r,int c,int[][] track){
        if(Math.min(r,c)<0){
            return false;
        }

        if(r>=track.length || c>=track[0].length){
            return false;
        }


        return track[r][c]!=0;
    }
    
    public long findIslandSum(int row,int col,int[][] track){
        Queue<int[]> queue = new LinkedList<>();
        long sum=0;
        queue.offer(new int[]{row,col});

        int[] newRow=new int[]{-1,1,0,0};
        int[] newCol=new int[]{0,0,-1,1};

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];

            if(track[r][c]==0){
                continue;
            }
            sum+=track[r][c];
            

            track[r][c]=0;


        // applying bfs appraoch 

            for(int i=0;i<4;i++){
                int nextRow=r+newRow[i];
                int nextCol=c+newCol[i];

                if(isValid(nextRow,nextCol,track)){
                    queue.offer(new int[]{nextRow,nextCol});
                }

            }


        }

        return sum;
    }



    public int countIslands(int[][] grid, int k) {
        int rowSize=grid.length;
        int colSize=grid[0].length;
        
        int[][] track=new int[rowSize][colSize];

        

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                track[i][j]=grid[i][j];
            }

        }


        int count=0;

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                int curr=track[i][j];

                if(curr==0){
                    continue;
                }

                long sum=findIslandSum(i,j,track);
               


                if(sum%k==0){
                    count++;
                }
            }

        }



        
        return count;
    }
}