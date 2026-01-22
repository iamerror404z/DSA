class Solution {

    public int cost(int[][] track,int i, int j){
        int m=track.length;
        int n=track[0].length;
        
        if(i+1>=m && j+1>=n){
            return 0;
        }

        int right=Integer.MAX_VALUE;
        int down=right;

        if(i+1<m && j+1<n){
            right=track[i][j+1];
            down=track[i+1][j];

            return Math.min(right,down);
        
        }else if(i+1<m){
            down=track[i+1][j];

            return down;
        }

        right=track[i][j+1];

        
        return right;
    }

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] track=new int[m][n];

       for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            track[i][j]+=grid[i][j] +cost(track,i,j);
        }
       }

       
        // for(int[] i:track){
        //     System.out.println(Arrays.toString(i));
        // }

    //    System.out.println(cost(track,1,1));
 



        return  track[0][0];
    }
}