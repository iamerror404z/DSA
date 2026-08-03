class Solution {
    public int maxDiff(int index,int[] stones,int[] memo){
        if(index>=memo.length){
           return 0;
        }

        if(memo[index]!=Integer.MIN_VALUE){
            return memo[index];
        }

        int max=Integer.MIN_VALUE;
        int sum=0;

        for(int i=index;i<Math.min(index+3, stones.length);i++){
            sum+=stones[i];
            int tempMax=sum-maxDiff(i+1,stones,memo);
            max=Math.max(max,tempMax);

        }

        memo[index]=max;


        return max;
    }

    public String stoneGameIII(int[] stoneValue) {
        int length=stoneValue.length;
        int[] memo=new int[length];
        Arrays.fill(memo,Integer.MIN_VALUE);


        int res=maxDiff(0,stoneValue,memo);
        String op="Alice";

        if(res==0){
            op="Tie";
        }else if(res<0){
            op="Bob";
        }




        return op;
        
    }
}