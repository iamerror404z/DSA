class Solution {
    public int maxDistance(String moves) {
        int[] dir=new int[4];

        /* 0 = up
        1=down
        2=left
        3=right
        */

        int changes=0;

        for(char ch:moves.toCharArray()){
            if(ch=='_'){
                changes++;
            }else if(ch=='U'){
                dir[0]++;
            }else if(ch=='D'){
                dir[1]++;
            }else if(ch=='L'){
                dir[2]++;
            }else{
                dir[3]++;
            }
        }

        int upDown=Math.abs(dir[0]-dir[1]);
        int leftRight=Math.abs(dir[2]-dir[3]);



        




        return upDown+leftRight+changes;
    }
}