class Solution {
   
   public int[] findNextPath(int dir,int r,int c,Node[][] memo){
    if(!memo[r][c].isMirror){
        return new int[]{r,c};
    }
        
    return dir==0?memo[r][c].down:memo[r][c].right;
   }

    public int uniquePaths(int[][] grid) {
        int rowSize=grid.length;
        int colSize=grid[0].length;

        int[] boundry={rowSize+1,colSize+1};
        // Memoization
        Node[][] memo=new Node[rowSize+1][colSize+1];

        // Destinaion
        memo[rowSize-1][colSize-1]=new Node(1);

        // Sentinel Nodes row Wise update
        memo[rowSize][colSize]=new Node(0);
        for(int i=0;i<=rowSize;i++){
            memo[i][colSize]=memo[rowSize][colSize];
        }

         // Sentinel Nodes col Wise update
         for(int i=0;i<=colSize;i++){
            memo[rowSize][i]=memo[rowSize][colSize];
        }

        // sentinel Node done!

        // Mod
        int mod=(int)Math.pow(10,9)+7;

        // processing the complete grid

        for(int i=rowSize-1;i>=0;i--){
            int r=i;

            

            for(int j=colSize-1;j>=0;j--){
                int c=j;
                
                if(r==rowSize-1 && c==colSize-1){
                    continue;
                }

                try{
                boolean isMirror=grid[r][c]==1;
                if(isMirror){
                    // proessing the mirror grids
                    int[] right=findNextPath(0,r,c+1,memo);
                    int[] down=findNextPath(1,r+1,c,memo);

                    memo[r][c]=new Node(right,down,true);
                    continue;
                }

                int[] right=findNextPath(0,r,c+1,memo);  //traveling in the right dir
                int[] down=findNextPath(1,r+1,c,memo);  //traveling in the down dir 
                int paths=0;

            long pathSum=((long)0)+memo[right[0]][right[1]].paths+memo[down[0]][down[1]].paths;
            paths=(int)(pathSum%mod);
                    
                

            
            memo[r][c]=new Node(paths);
            }
            catch (Exception E){
                System.out.println("Exception Caught");
            }}
        }




        return memo[0][0].paths;
    }

    
}

class Node{
    int paths;
    int[] right,down;
    boolean isMirror;
    
    Node(int[] right,int[] down,boolean isMirror){
        this.paths=0;
        this.right=right;
        this.down=down;
        this.isMirror=isMirror;
    }

    Node(int paths){
        this.paths=paths;
        right=down=null;
        isMirror=false;

    }

}