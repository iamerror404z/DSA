class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
       Long ans=Long.MAX_VALUE;

        if(costBoth>cost1+cost2){
            long temp=((long)cost1*need1)+((long)cost2*need2);
            ans=Math.min(ans,temp);
        }
        long temp=1;
        temp=((long)Math.max(need1,need2)*costBoth);
        ans=Math.min(ans,temp);

        if(need1<=need2){
            temp=((long)need1*costBoth);
            temp+=((long)(need2-need1)*cost2);
            ans=Math.min(ans,temp);
        }else{
            temp=((long)need2*costBoth);
            temp+=((long)(need1-need2)*cost1);
            ans=Math.min(ans,temp);
        }
        


        return  ans;
    }
}