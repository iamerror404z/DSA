class Solution {

    public int dp(long curr,int[] bt,int limit){
        int nextRes=0;
        
        

        if(curr>=limit){
            return 0;
        }
        
        int start=1;

        if(curr>0){
            start=0;
        }

        for(int i=start;i<=9;i++){
            if(bt[i]==0){
                bt[i]=1;
                long pass=(curr*10)+i;
                nextRes+=dp(pass,bt,limit);
                bt[i]=0;
            }

        }

        return 1+nextRes;

    }



    public int countNumbersWithUniqueDigits(int n) {
        int ans=0;
        int[] bt=new int[10];

        int limit=(int)Math.pow(10,n);


        ans=dp(0,bt,limit);


        return ans;
    }
}