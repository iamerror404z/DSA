class Solution {

    public int dp(int left,int right,int[][] memo,String s){
        if(left==right){
            return 1;
        }

        char ch1=s.charAt(left);
        char ch2=s.charAt(right);


        if(left+1==right && ch1==ch2){
            return 2;
        }

        if(memo[left][right]!=-1)
        {
            return memo[left][right];
        }


        int skipLeft=dp(left+1,right,memo,s);
        int skipRight=dp(left,right-1,memo,s);


        int take=0;

        if(ch1==ch2){
            take=dp(left+1,right-1,memo,s)+2;


        }

        int res=Math.max(take,
        Math.max(skipLeft,skipRight));

        memo[left][right]=res;
        return res;
    }

    public int longestPalindromeSubseq(String s) {
        int n=s.length();

        int[][] memo=new int[n][n];

        for(int i[]:memo){
            Arrays.fill(i,-1);
        }
        
        return dp(0,n-1,memo,s);

    }
}