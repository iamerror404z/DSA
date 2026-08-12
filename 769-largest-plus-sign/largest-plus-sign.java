class Solution {
    public int[][] buildDown(int[][] mat){
        int n=mat.length;
        int[][] down=new int[n+1][n];

        // process edge cases

        for(int i=0;i<n;i++){
            down[n][i]=n;
        }


        for(int c=n-1;c>=0;c--){
            for(int r=n-1;r>=0;r--){
                int curr=mat[r][c];

                if(curr==0){
                    down[r][c]=r;
                }else{
                    down[r][c]=down[r+1][c];
                }

            }
        }
        





        return down;
    }
    
    // buildRight

     public int[][] buildRight(int[][] mat){
        int n=mat.length;
        int[][] right=new int[n][n+1];

        // process edge cases

        for(int i=0;i<n;i++){
            right[i][n]=n;
        }


        for(int r=n-1;r>=0;r--){

            for(int c=n-1;c>=0;c--){
                int curr=mat[r][c];

                if(curr==0){
                    right[r][c]=c;
                }else{
                    right[r][c]=right[r][c+1];
                }
            }
            
        }
        





        return right;
    }


    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] mat=new int[n][n];
        for(int i[]:mat){
            Arrays.fill(i,1);
        }

        for(int curr[]:mines){
            int r=curr[0];
            int c=curr[1];

            mat[r][c]=0;
        }


        

        int[][] down=buildDown(mat);

       
        
        int[][] right=buildRight(mat);

       

        int max=0;

        int[] up=new int[n];

        Arrays.fill(up,-1);

        for(int i=0;i<n;i++){
            
            int left=-1;
            for(int j=0;j<n;j++){
                int curr=mat[i][j];

                if(curr==0){
                    up[j]=i;
                    left=j;
                    continue;
                }


                int leftLen=j-left;
                int upLen=i-up[j];

                int downLen=down[i][j]-i;
                int rightLen=right[i][j]-j;

                int min=Math.min(Math.min(leftLen,upLen),Math.min(downLen,rightLen));

                max=Math.max(max,min);
            }
        }




        return max;
    }   
}