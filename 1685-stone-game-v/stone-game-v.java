class Solution {
    public int dp(int start,int end,int[][] memo,long[] prefixSum){
        if(start>=end){
            return 0;
        }

        

        if(memo[start][end]!=-1){
            return memo[start][end];
        }



        int res=0;

        for(int i=start;i<end;i++){
            long leftSub=start-1>=0?prefixSum[start-1]:0;
            long left=prefixSum[i]-leftSub;

            long rightSub=prefixSum[i];
            long right=prefixSum[end]-rightSub;

            if(left<=right){
                long tempRes=left+dp(start,i,memo,prefixSum);
                res=Math.max(res,(int)tempRes);
            }
            if(right<=left){
                long tempRes=right+dp(i+1,end,memo,prefixSum);
                res=Math.max(res,(int)tempRes);
            }



        }

        memo[start][end]=res;


        return res;

    }




    public int stoneGameV(int[] stoneValue) {
        int length=stoneValue.length;

        long[] prefixSum=new long[length];
        int prev=0;

        for(int i=0;i<length;i++){
            int curr=stoneValue[i];

            prefixSum[i]=curr+prev;

            prev+=curr;
        }

        int[][] memo=new int[length][length];

        for(int i[]:memo){
            Arrays.fill(i,-1);
        }

        return dp(0,length-1,memo,prefixSum);
    }
}