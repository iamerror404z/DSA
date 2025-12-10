class Solution {

    public int LCS(int index1,int index2,int[][] dp,String t1,String t2){
        if(index1<=-1 || index2<=-1){
            return 0;
        }
        
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }

        if(t1.charAt(index1)==t2.charAt(index2)){
            return dp[index1][index2]=1+LCS(index1-1,index2-1,dp,t1,t2);
        }

        

        return dp[index1][index2]=Math.max(LCS(index1,index2-1,dp,t1,t2),LCS(index1-1,index2,dp,t1,t2));

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        LCS(m-1,n-1,dp,text1,text2);
        int max=0;

        for(int[] i:dp){
            for(int j:i){
                if(j>max){
                    max=j;
                }
            }
        }

        System.out.println(max);
        return max;
    }
}