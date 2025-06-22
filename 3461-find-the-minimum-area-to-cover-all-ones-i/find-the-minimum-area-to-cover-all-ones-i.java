class Solution {
    public int minimumArea(int[][] grid) {
        int RSize=grid.length;
        int CSize=grid[0].length;

        int[] row={RSize-1,0};
        int[] col={CSize-1,0};

        for (int i=0;i<CSize;i++){
            for(int j=0;j<RSize;j++){
                if(grid[j][i]==1){

                    if(j<row[0]){
                        row[0]=j;
                    }if(j>row[1]){
                        row[1]=j;
                    }
                }
            }}

            for (int i=0;i<CSize;i++){
                for(int j=0;j<RSize;j++){
                    if(grid[j][i]==1){
                        if(i>col[1]){
                            col[1]=i;
                        }
                        if(i<col[0]){
                            col[0]=i;
                        }

                    }
                }
            }

        int ans=(col[1]-col[0]+1)*(row[1]-row[0]+1);
        System.out.println(Arrays.toString(row));

        return ans;
        
    }
}