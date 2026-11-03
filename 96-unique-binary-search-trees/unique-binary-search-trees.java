class Solution {

    public int numOfTrees(int left,int right,int[][] memo){
        if(left>right){
            return 1;
        }

        if(left==right){
            memo[left][right]=1;

            return 1;
        }

        if(memo[left][right]!=-1){
            return memo[left][right];
        }

        int res=0;
        for(int i=left;i<=right;i++){
            int leftTrees=numOfTrees(left,i-1,memo);
            int rightTrees=numOfTrees(i+1,right,memo);

            res+=(leftTrees*rightTrees);
        }


        return memo[left][right]=res;
    }



    public int numTrees(int n) {
        int[][] memo = new int[n+1][n+1];

        for(int i[]:memo){
            Arrays.fill(i,-1);
        }


        return numOfTrees(1,n,memo);
    }
}