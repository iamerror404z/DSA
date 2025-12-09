class Solution {
    List<Integer> list=new LinkedList<>();
    int size=0;
    int up,down,left,right,count;

    public  void horizontal(int[][] mat,int dir){
        if(count==size){
            // System.out.println("limit reached buddy");
            return;
        }
        int move=0;
        int pos=0;
        int start=0,end=0;

        if(dir==1){
            start=up+1;
            end=down;
            move=1;
            pos=right+1;
        }
        if(dir==3){
            start=down-1;
            end=up;
            move=-1;
            pos=left-1;
        }

        for(int i=start;i!=end;i+=move){
            list.add(mat[pos][i]);
            count++;

        }
        if(dir==1){
        right++;}
        else{
            left--;
        }
    }

    public void vertical(int[][] mat,int dir){
        if(count==size){
            return;
        }
        int start=0,end=0,move=0,pos=0;

        if(dir==2){
            start=right+1;
            end=left;
            pos=down-1;
            move=1;

        }else{
            start=left-1;
            end=right;
            pos=up+1;
            move=-1;
        }

        for(int i=start;i!=end;i+=move){
            list.add(mat[i][pos]);
            count++;
        }
        
        if(dir==2){
        down--;}
        else{
            up++;
        }

    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        size=m*n;
        up=-1;
        down=n;
        right=-1;
        left=m;
        count=0;
        int dir=1;
        
        while(count!=size){
            horizontal(matrix,1);
            vertical(matrix,2);
            horizontal(matrix,3);
            vertical(matrix,4);
        }

        return list;
    }
}