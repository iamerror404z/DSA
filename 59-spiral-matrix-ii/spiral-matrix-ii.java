class Solution {
    public int[][] generateMatrix(int n) {
        int limit=n*n;
        int[][] ans=new int[n][n];
        if(n==1){
            ans[0][0]=1;
            return ans;
        }


        int right=-1;
        int left=n;
        int up=-1;
        int down=n;
        int dir=1;
        int count=n*n;
        int move=0;
        int start=0,end=0,pos=0;
        int temp=1;

        while(temp!=(n*n)+1){
            if(dir==1){
                start=up+1;
                end=down;
                pos=right+1;
                move=1;
            }else if(dir==2){
                start=right+1;
                end=left;
                pos=down-1;
                move=1;
            }else if(dir==3){
                start=down-1;
                end=up;
                move=-1;
                pos=left-1;
            }else{
                start=left-1;
                end=right;
                move=-1;
                pos=up+1;
            }
            
            if(dir==1 || dir==3){
                for(int i=start;i!=end;i+=move){
                    ans[pos][i]=temp;
                    // System.out.println(temp);
                    temp++;
                }
            }

            else{
                for(int i=start;i!=end;i+=move){
                    ans[i][pos]=temp;
                    // System.out.println(temp);
                    temp++;
                }
                // System.out.println("else loop completed\n\n\n");
            }


            if(dir==1){
                right++;
            }else if(dir==2){
                down--;
            }else if(dir==3){
                left--;
            }else{
                up++;
            }
            
            dir++;
            dir=dir%4==0?4:dir%4;
        }

        System.out.println(temp);
        return ans;
    }
}