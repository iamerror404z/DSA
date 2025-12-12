class Solution {
    public int upWards(int[] pos,int index,int[][] mat,int[] ans){
        if(index>=mat[0].length*mat.length){
            return index;
        }

        int row=pos[0];
        int col=pos[1];


        while(row>=0 && col<mat[0].length){
            ans[index]=mat[row][col];
            row--;
            col++;
            index++;
        }

        row++;
        col--;

        if(col<mat[0].length-1){
         pos[0]=row;
         pos[1]=col+1;    
        }
        else{
            pos[0]=row+1;
            pos[1]=col;
        }

        return index;
    }
    public int  downWards(int pos[],int index,int[][] mat,int[] ans){
        if(index>=mat[0].length*mat.length){
            return index;
        }

        int row=pos[0];
        int col=pos[1];

        while(row<mat.length && col>=0){
            ans[index]=mat[row][col];
            row++;
            col--;
            index++;
        }

        row--;
        col++;
        if(row+1<mat.length){
            pos[0]=row+1;
            pos[1]=0;
        }
        else{
            pos[0]=row;
            pos[1]=col+1;
        }


        return index;
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] ans=new int[n*m];
        int[] pos=new int[]{0,0};
        int  index=0;

        while(index<m*n){
            index=upWards(pos,index,mat,ans);
            index=downWards(pos,index,mat,ans);
        }
        
        return ans;

    }
}