class Solution {
    public int kthFactor(int n, int k) {
        int[] factors=new int[n+1];
        int count=0;

        for(int i=1;i<=n;i++){
            if(n%i==0){
                factors[i]=1;
                count++;
            }
        }
        if(k>count){
            return -1;
        }
        int pointer=1;
         count=0;
        while(pointer<=n && count!=k){
            if(factors[pointer]==1){
                count++;
            }
            if(count!=k){
            pointer++;}
            
        }

        return pointer;
    }
}