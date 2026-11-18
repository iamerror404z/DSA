class Solution {

    public int dp(int index,int prev,int[][] memo,
    String s){
        if(index<0){
            if(prev!=2){
                return s.length();
            }

            return 0;
        }

        if(memo[index][prev]!=-1){

            return memo[index][prev];
        }

        int curr=s.charAt(index)-'0';

        int res=0;
        
        if(prev!=2){
            int next=dp(index-1,2,memo,s);

            if(curr!=prev){
                next++;
            }

            res=next;
        }else if(index-1>=0 && s.charAt(index-1)==curr){

            res=dp(index-2,2,memo,s);
        }else{
            int take=dp(index-1,curr,memo,s);
            int swap=dp(index-1,curr^1,memo,s)+1;

            res=Math.min(take,swap);
        }


        



        return memo[index][prev]=res;
    }




    public int minChanges(String s) {
        int size=s.length();

        int[][] memo=new int[size][3];

        for(int i[]:memo){
            Arrays.fill(i,-1);
            
        }


        return dp(size-1,2,memo,s);
    }
}