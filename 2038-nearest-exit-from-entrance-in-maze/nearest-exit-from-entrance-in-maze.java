class Solution {
    // 110 lines lets optimize it 

    public void adder(int r,int c,int val,Queue<int[]> queue){
        queue.add(new int[]{r,c,val});
    }


    public int nearestExit(char[][] maze, int[] entrance) {
        int[] min=new int[]{Integer.MAX_VALUE,0};
        Queue<int[]> queue=new LinkedList<>();

        int r=entrance[0];
        int c=entrance[1];

        int rowSize=maze.length;
        int colSize=maze[0].length;

        if(r-1>=0 &&maze[r-1][c]=='.'){
            adder(r-1,c,1,queue);
        }

        if(r+1<rowSize && maze[r+1][c]=='.'){
            adder(r+1,c,1,queue);
        }

        if(c-1>=0 && maze[r][c-1]=='.'){
            adder(r,c-1,1,queue);
        }
        if(c+1<colSize && maze[r][c+1]=='.'){
              adder(r,c+1,1,queue);
        }

        maze[r][c]='+';
        




        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            r=curr[0];
            c=curr[1];
            int val=curr[2];

            if(maze[r][c]=='+'){
                continue;
            }

            maze[r][c]='+';

            if(r-1>=0){
                if(maze[r-1][c]=='.'){
                    adder(r-1,c,val+1,queue);
                }

            }else{
                return val;
            }

            if(r+1<rowSize){
                if(maze[r+1][c]=='.'){
                    adder(r+1,c,val+1,queue);
                }

            }else{
                return val;
            }

            if(c-1>=0){
                if(maze[r][c-1]=='.'){
                    adder(r,c-1,val+1,queue);
                }

            }else{
                return val;
            }

            if(c+1<colSize){
                if(maze[r][c+1]=='.'){
                    adder(r,c+1,val+1,queue);
                }

            }else{
                return val;
            }



        }



        return -1;
    }   
}