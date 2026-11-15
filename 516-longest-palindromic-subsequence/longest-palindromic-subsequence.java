class Solution {
    public int dpMethod(int index1,int index2,String s,int[][] dp){
        if(index1>index2){
            return 0;
        }

        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }

        


        char ch1=s.charAt(index1);
        char ch2=s.charAt(index2);
        int currSize=0;

        
        if(index1==index2 && ch1==ch2){
            return 1;
        }

        if(ch1==ch2){
            currSize=2+dpMethod(index1+1,index2-1,s,dp);
            

        }else{
                if(index1+1<s.length()){
                    currSize=0+dpMethod(index1+1,index2,s,dp);
                }

                if(index2-1>=0){
                    currSize=Math.max(currSize,dpMethod(index1,index2-1,s,dp));
                }
            }
    
        dp[index1][index2]=currSize;

        return currSize;
    }



    public int longestPalindromeSubseq(String s) {
       int size=s.length();

        int[][] dp=new int[size][size];

        for(int i[]:dp){
            Arrays.fill(i,-1);
        }

        


        return  dpMethod(0,size-1,s,dp);
        
    }
}
