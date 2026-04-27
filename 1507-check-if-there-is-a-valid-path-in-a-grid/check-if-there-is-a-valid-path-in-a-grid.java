class Solution {
    public int isPossible(int curr,int next,int dir){
        if(curr==1){
            if(dir==1 && (next==3 || next==1)){
                return 1;
            }else if(dir==3 && (next==4 || next==1)){
                return 1;
            }

            return 0;

        }else if(curr==2){

            if(dir==0 && (next>=2 && next<=4)){
                return 1;
            }else if((dir==2) && (next==5 || next==6 || next==2)){
                return 1;
            }

            return 0;
        }else if(curr==3){
            if(dir==3 && (next==1 || next==4 || next==6)){
                return 1;
            }else if(dir==2 && (next==2 || next==5 || next==6)){
                return 1;
            }

            return 0;
            
        }else if(curr==4){
            if(dir==1 && (next==1 || next==3 || next==5)){
                return 1;
            }else if(dir==2 && (next==2 || next==5 || next==6)){
                return 1;
            }
            return 0;
        }else if(curr==5){
            if((dir==0) && (next!=1 && next!=6)){
                return 1;
            }else if((dir==3) && (next!=3 && dir!=2)){
                return 1;
            }
            return 0;
        }

        if ((dir==0) && (next!=1 && next!=5)){
            return 1;
        }else if((dir==1) && (next!=4 && next!=2)){
            return 1;
            
        }
        return 0;


       
        }
    

    public boolean hasValidPath(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        int rowSize=grid.length;
        int colSize=grid[0].length;

        int[][] track=new int[rowSize][colSize];
        int count=0;

        while(queue.size()!=0 && track[rowSize-1][colSize-1]!=1){
            count++;
            int[] axis=queue.poll();
            int r=axis[0];
            int c=axis[1];

            if(r-1>=0 && track[r-1][c]==0 && isPossible(grid[r][c],grid[r-1][c],0)==1){
                queue.add(new int[]{r-1,c});
            }
            if(c+1<colSize && track[r][c+1]==0 && isPossible(grid[r][c],grid[r][c+1],1)==1){
                queue.add(new int[]{r,c+1});
            }if(r+1<rowSize && track[r+1][c]==0 && isPossible(grid[r][c],grid[r+1][c],2)==1){
                queue.add(new int[]{r+1,c});

            }if(c-1>=0 && track[r][c]==0 && isPossible(grid[r][c],grid[r][c-1],3)==1){
                queue.add(new int[]{r,c-1});
            }

            track[r][c]=1;
        }



        return track[rowSize-1][colSize-1]==1; 
    }
}