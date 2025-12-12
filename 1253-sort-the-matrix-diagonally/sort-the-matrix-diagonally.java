class Solution {

    public  int traverse(int[] pos,int index,int[][] mat,LinkedList<LinkedList<Integer>> wrapped){
        if(index>mat[0].length*mat.length){
            return index;
        }

        int row=pos[0];
        int col=pos[1];
        LinkedList<Integer> inner=new LinkedList<>();

        while(row<mat.length && col<mat[0].length){
            inner.add(mat[row][col]);
            index++;
            row++;
            col++;
        }

        Collections.sort(inner);
        wrapped.add(inner);
        
        
        row--;
        col--;

        if(pos[0]>0){
            pos[0]--;
            pos[1]=0;
            
        }else{
            pos[1]++;
        }


        return index;

    }

        public  int assign(int[] pos,int index,int[][] mat,LinkedList<LinkedList<Integer>> wrapped,int[][] ans){
        if(index>mat[0].length*mat.length){
            return index;
        }

        int row=pos[0];
        int col=pos[1];
        LinkedList<Integer> inner=wrapped.pop();

        while(row<mat.length && col<mat[0].length){
            ans[row][col]=inner.pop();
            index++;
            row++;
            col++;
        }

        
        
        row--;
        col--;

        if(pos[0]>0){
            pos[0]--;
            pos[1]=0;
            
        }else{
            pos[1]++;
        }


        return index;

    }


    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] pos=new int[]{m-1,0};
        
        if(n*m<=1){
            return mat;
        }
        int index=0;


        LinkedList<LinkedList<Integer>> wrapped=new LinkedList<>();

        while(index!=m*n){
            index=traverse(pos,index,mat,wrapped);
        }

        int[][] ans=new int[m][n];
        index=0;
        pos[0]=m-1;;
        pos[1]=0;;

        while(index!=m*n){
            index=assign(pos,index,mat,wrapped,ans);
        }
       

        return ans;
    }
}