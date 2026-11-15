class Solution {

    public int[] dfs(int left,int right,int[][][] memo,String s){
        if(left==right){



            return new int[]{left,1};
        }

        if(right==left+1 && s.charAt(left)==s.charAt(right)){
            return new int[]{left,2};
        }



        if(memo[left][right][0]!=-1){
            
            return new int[]{memo[left][right][0],
            memo[left][right][1]};
        }

        int[] take=new int[]{left,1};
        
        int[] skipLeft=dfs(left+1,right,memo,s);
        int[] skipRight=dfs(left,right-1,memo,s);


        if(s.charAt(left)==s.charAt(right)){
            take=dfs(left+1,right-1,memo,s);

            int start=take[0];
            int end=take[0]+take[1];

            if(start==left+1 && end==right){
                take[0]=left;
                take[1]=take[1]+2;
            }else{
                take[0]=left;
                take[1]=1;
            }


        }


        int[] res=new int[2];
        if(take[1]>=skipLeft[1] && take[1]>=skipRight[1]){

            res=take;
        }else if(skipLeft[1]>=skipRight[1]){
            
            res=skipLeft;
        }else{
            res=skipRight;
        }

        





        memo[left][right][0]=res[0];
        memo[left][right][1]=res[1];
        return res;
    }



    public String longestPalindrome(String s) {
        int n =s.length();
        int[][][]  memo=new int[n][n][2];


        for(int i[][]:memo){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
        }

        
        int[] call=dfs(0,n-1,memo,s);


        return s.substring(call[0],call[0]+call[1]);
    }
}