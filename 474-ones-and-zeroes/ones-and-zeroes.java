class Solution {
    public int countBits(String curr){
        int oneCount=0;

        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i)=='1'){
                oneCount++;
            }
        }


        return oneCount;

    }



    public int dpSum(int index,int targetZero,int targetOne,int[][][] dp,int[][] map){
        if(index==0){
            int currOne=map[index][1];
            int currZero=map[index][0];
            int res=0;

            if(currOne<=targetOne && currZero<=targetZero){
               res=1;
            }

            dp[index][targetZero][targetOne]=res;



            return dp[index][targetZero][targetOne];
        }
        

        if(dp[index][targetZero][targetOne]!=-1){
            return dp[index][targetZero][targetOne];
        }

        if(targetOne==0 && targetZero==0){
            dp[index][targetZero][targetOne]=0;

            return dp[index][targetZero][targetOne];
        }


        int max=dpSum(index-1,targetZero,targetOne,dp,map);


        int currOne=map[index][1];
        int currZero=map[index][0];

        int newTargteOne=targetOne-currOne;
        int newTargetZero=targetZero-currZero;

        if(newTargteOne>=0 && newTargetZero>=0){
            int included=dpSum(index-1,newTargetZero,newTargteOne,dp,map)+1;
            max=Math.max(max,included);
        }

        dp[index][targetZero][targetOne]=max;

        
        

        



        return dp[index][targetZero][targetOne];
    }


    public int findMaxForm(String[] strs, int m, int n) {
        int size=strs.length;
        int[][][] dp=new int[size][m+1][n+1];

        for(int []i[]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        

        int[][] map=new int[size][2];

        for(int i=0;i<size;i++){
            map[i][1]=countBits(strs[i]);
            map[i][0]=strs[i].length()-map[i][1];
        }


        dpSum(size-1,m,n,dp,map);





        return dp[size-1][m][n];
    }
}