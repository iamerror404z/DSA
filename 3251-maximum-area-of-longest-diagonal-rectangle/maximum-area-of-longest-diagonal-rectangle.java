class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int len=dimensions.length;
        float[] diagonals=new float[len];
        int point=0;
        float max=(float) -1;
        for(int[] temp:dimensions){
            diagonals[point]=(float)Math.sqrt((temp[0]*temp[0])+(temp[1]*temp[1]));
            if(diagonals[point]>max){
                max=diagonals[point];

            }
            point++;

        }

        int ans=0;
        
        for(int i =0;i<len;i++){
            if(diagonals[i]>=max){
                ans=Math.max(ans,dimensions[i][0]*dimensions[i][1]);
            }
        }
        


        return ans;
    }
}