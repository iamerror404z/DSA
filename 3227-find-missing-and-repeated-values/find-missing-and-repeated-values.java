class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int size=n*n;
        int[] ans=new int[2];
        int[] step=new int[size+1];
        for (int[] row:grid){
            for(int j:row){
                step[j]+=1;
            }
        }

        int trigger=0;
        for (int i=1;i<=size;i++){
            if(step[i]==2){
                ans[0]=i;
                trigger++;
            }
            if(step[i]==0){
                ans[1]=i;
                trigger++;
            }
            if(trigger>=2){
                return ans;
            }
        }

        return ans;
    }
}