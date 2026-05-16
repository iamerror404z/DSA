class Solution {
    public  int pathCount(int index,int target,int[] coins,int[][] dp){
        if(index==0){
            if(target==0 || target%coins[index]!=0){
                dp[index][target]=0;
            }else if(target%coins[index]==0){
                dp[index][target]=1;
            }

            return dp[index][target];
        }


        if(dp[index][target]!=-1){
            return dp[index][target];
        }


        if(target==0){
                
            dp[index][target]=0;
          
                
            return dp[index][target];
        }

        
        
        int times=target/coins[index];

        int res=0;

        for(int i=times;i>=0;i--){
            int newtarget=target-(coins[index]*i);
            int tempRes=pathCount(index-1,newtarget,coins,dp);

            if(tempRes==0 && newtarget==0){
                res++;
            }else{
                res+=tempRes;
            }

           
        }

    
        
        dp[index][target]=res;

        return dp[index][target];
    } 




    public int change(int amount, int[] coins) {
        int size=coins.length;

        if(amount==0){
            return 1;
        }

        int[][] dp=new int[size][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }

        
        pathCount(size-1,amount,coins,dp);

        // System.out.println(dp[size-1][amount]);

        // if(size-2>=0){
        //     System.out.println(dp[size-2][5]);
        // }






        return dp[size-1][amount];
    }
}