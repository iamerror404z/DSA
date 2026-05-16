class Solution {

    public  int minCoins(int index,int target,int[] coins,int[][] dp){
        if(index==0){
            // System.out.println("coins is :"+coins[0]);
            // System.out.println("num is :"+target);

            if(target%coins[0]==0){
                dp[index][target]=target/coins[index];
            }else{
                dp[index][target]=-1;
            }

            // System.out.println("reult is :"+dp[index][target]);
            return dp[index][target];
        }


        if(dp[index][target]!=-2){
            return dp[index][target];
        }


        if(target==0){
                
            dp[index][target]=0;
          
                
            return dp[index][target];
        }


        int times=target/coins[index];
        int[] res=new int[2];


        res[0]=Integer.MAX_VALUE;
        res[1]=-1;

        for(int i=times;i>=0;i--){
            int newtarget=target-(coins[index]*i);
            int tempRes=minCoins(index-1,newtarget,coins,dp);

            if(tempRes>=0){
                res[1]=0;
                res[0]=Math.min(res[0],tempRes+i);
            }

           
        }

    
        
        dp[index][target]=res[1]==-1?-1:res[0];


        // System.out.println("coins is : "+coins[index]);
        // System.out.println("Number of coins is : "+dp[index][target]);
        return dp[index][target];
    } 



    public int coinChange(int[] coins, int amount) {
        int size=coins.length;
        

        int[] dp[]=new int[size][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-2);
        }

        // for(int i[]:dp){
        //     System.out.println(Arrays.toString(i));
        // }
        
        Arrays.sort(coins);

        minCoins(size-1,amount,coins,dp);

        
        System.out.println(dp[size-1][amount]);
        




        

    
        return dp[size-1][amount];
    }
}