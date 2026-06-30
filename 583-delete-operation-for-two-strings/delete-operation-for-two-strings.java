class Solution {
    public int minRemoves(int index1,int index2,String w1,String w2,int[][] dp){
        if(index1<0 || index2<0){
            return Math.max(index1,index2)+1;
        }
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }


        int min=Integer.MAX_VALUE;

        if(w1.charAt(index1)==w2.charAt(index2)){
            min=minRemoves(index1-1,index2-1,w1,w2,dp);
        }else{
            int min1=minRemoves(index1-1,index2,w1,w2,dp)+1;
            int min2=minRemoves(index1,index2-1,w1,w2,dp)+1;
            min=Math.min(min1,min2);
        }
        

        dp[index1][index2]=min;



        return min;
    }



    public int minDistance(String word1, String word2) {
     int size1=word1.length();
     int size2=word2.length();
     int[][] dp=new int[size1][size2];

     for(int i[]:dp){
        Arrays.fill(i,-1);
     }
    
    int ans=minRemoves(size1-1,size2-1,word1,word2,dp);



     return ans;   
    }
}