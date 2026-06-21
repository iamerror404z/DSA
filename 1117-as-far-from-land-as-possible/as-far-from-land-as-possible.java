class Solution {

    public void adder(int row,int col,int distance,Queue<int[]> queue){
        queue.add(new int[]{row,col,distance});
    }


    public void validator(int row,int col,int distance,Queue<int[]> queue,int[][] grid,int size){
        boolean status=(row>=0 && row<size) && (col>=0 && col<size) && (grid[row][col]==0);
        
        if(!status){
            return ;
        }

        adder(row,col,distance,queue);
    }

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int size=grid.length;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                
                if(grid[i][j]==1){
                    validator(i-1,j,2,queue,grid,size);
                    validator(i+1,j,2,queue,grid,size);
                    validator(i,j-1,2,queue,grid,size);
                    validator(i,j+1,2,queue,grid,size);
                   
                }
            }
        }


        int max=0;


        while(!queue.isEmpty()){
            int curr[]=queue.poll();
            int i=curr[0];
            int j=curr[1];
            int distance=curr[2];

            if(grid[i][j]!=0){
                continue;
            }
            
            max=Math.max(max,distance);


            grid[i][j]=1;
            distance++;

            validator(i-1,j,distance,queue,grid,size);
            validator(i+1,j,distance,queue,grid,size);
            validator(i,j-1,distance,queue,grid,size);
            validator(i,j+1,distance,queue,grid,size);
            
        }





        return max-1;
    }
}