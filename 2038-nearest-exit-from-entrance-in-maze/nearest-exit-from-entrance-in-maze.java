class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[] min=new int[]{Integer.MAX_VALUE,0};
        Queue<int[]> queue=new LinkedList<>();

        int r=entrance[0];
        int c=entrance[1];

        int rowSize=maze.length;
        int colSize=maze[0].length;

        if(r-1>=0 &&maze[r-1][c]=='.'){
            queue.add(new int[]{r-1,c,1});
        }

        if(r+1<rowSize && maze[r+1][c]=='.'){
            queue.add(new int[]{r+1,c,1});
        }

        if(c-1>=0 && maze[r][c-1]=='.'){
            queue.add(new int[]{r,c-1,1});
        }
        if(c+1<colSize && maze[r][c+1]=='.'){
            queue.add(new int[]{r,c+1,1});
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
                    queue.add(new int[]{r-1,c,val+1});
                }

            }else{
                // System.out.println(Arrays.toString(curr));
                min[0]=Math.min(min[0],curr[2]);
                min[1]=1;
            }

            if(r+1<rowSize){
                if(maze[r+1][c]=='.'){
                    queue.add(new int[]{r+1,c,val+1});
                }

            }else{
                
                // System.out.println(Arrays.toString(curr));
                min[0]=Math.min(min[0],val);
                min[1]=1;
            }

            if(c-1>=0){
                if(maze[r][c-1]=='.'){
                    queue.add(new int[]{r,c-1,val+1});
                }

            }else{
                
                // System.out.println(Arrays.toString(curr));
                min[0]=Math.min(min[0],val);
                min[1]=1;
                
            }

            if(c+1<colSize){
                if(maze[r][c+1]=='.'){
                    queue.add(new int[]{r,c+1,val+1});
                }

            }else{
                
                // System.out.println(Arrays.toString(curr));
                min[0]=Math.min(min[0],val);
                min[1]=1;
            }



        }


        if(min[1]==0){
            return -1;
        }







        return min[0];
    }   
}