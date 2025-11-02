class Solution {

    public void south(int[][] arr,int row,int col){

        int size=arr.length;
       
        while(row<size && Math.abs(arr[row][col])==1){
            arr[row++][col]=-1;
        }
        
        return;
    }

    public void north(int[][] arr,int row,int col){
        int size=arr.length;

        while(row>=0 && Math.abs(arr[row][col])==1 ){
            arr[row--][col]=-1;
        }


        return;
    }


    public void west(int[][] arr,int row,int col){

        while(col>=0 && Math.abs(arr[row][col])==1){
            arr[row][col--]=-1;
        }

        return;
    }


    public void east(int[][] arr,int row,int col){
        int size=arr[0].length;

        while(col<size && Math.abs(arr[row][col])==1){
            arr[row][col++]=-1;
        }

        return;
    }


    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] area=new int[m][n];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                area[i][j]=1;
                
            }
        }

    
        for(int[] i:guards){
            area[i[0]][i[1]]=2;
        }

        for(int i[]:walls){
            area[i[0]][i[1]]=3;
        }
        int a=1,b=1;

        // lets apply the process here
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(area[i][j]==2){
                    north(area,i-1,j);
                     south(area,i+1,j);
                    west(area,i,j-1);
                    east(area,i,j+1);
                }
            }
        }

        int count=0;

        for(int[] i:area){
            for(int j:i){
                if(j==1){
                    count++;
                }
            }
        }




        return count;
        
    }
}