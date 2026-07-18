class Solution {

    

    // buinsess logic errror forgot hot queens moves 
    // especially missed the diagonal movess

    public List<String> buildPath(boolean[][] bt){
        List<String> inner=new LinkedList<>();

        for(boolean i[]:bt){
            StringBuilder sb=new StringBuilder();
            for(boolean way:i){
                if(way){
                    sb.append('Q');
                }else{
                    sb.append(".");
                }

            }
            inner.add(sb.toString());
        }



        return inner;
    }


    public void DP(int row,boolean[][] bt,boolean[][] map
    ,List<List<String>> wrapped){


        if(row<0){
            List<String> path=buildPath(bt);
            wrapped.add(path);
            return ;
        }

        int size=bt.length;


        for(int i=0;i<size;i++){
            int col=i;
            int upperPos=col-row+size-1;
            int lowerPos=col+row;

            // boolean vals

            boolean colBlocked=map[0][i];
            boolean lowerDiagonalBlocked=map[1][lowerPos];
            boolean upperDiagonalBlocked=map[2][upperPos];



            if(colBlocked || upperDiagonalBlocked || lowerDiagonalBlocked){
                continue;
            }


            // block the states
            map[0][col]=true;
            map[1][lowerPos]=true;
            map[2][upperPos]=true;
            
            bt[row][col]=true;

            DP(row-1,bt,map,wrapped);

            // release the states
            map[0][col]=false;
            map[1][lowerPos]=false;
            map[2][upperPos]=false;
            
            bt[row][col]=false;


            

        }


       


    }




    /* map[0] ==> refers to the  coloumn
        map[1]==>refer to lower part
        map[2]=refers to the lower part

    
    */
    public List<List<String>> solveNQueens(int n) {
        
        // n=9;
        boolean[][] bt=new boolean[n][n];
        List<List<String>> wrapped=new LinkedList<>();



        int dSize=(2*n)-1;
        boolean[][] map=new boolean[3][dSize];

        /* map :
            0 row ==> refers to the col map 
            1 row ==>refers to the down diagonal
            2 row==> refers to the upper diagonal

            */






        // calling the method 
        DP(n-1,bt,map,wrapped);







        return wrapped;        
    }
}