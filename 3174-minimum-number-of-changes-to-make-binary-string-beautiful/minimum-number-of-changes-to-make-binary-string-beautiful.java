class Solution {

    public int dp(int index,int prev,int type,int[][][] memo,
    String s){
        if(index<0){
            if(type==1){
                return s.length();
            }

            return 0;
        }

        if(memo[index][prev][type]!=-1){

            return memo[index][prev][type];
        }

        int curr=s.charAt(index)-'0';

        int res=0;
        if(type==1){
            int next=dp(index-1,prev,(type+1)%2,memo,s);

            if(curr!=prev){
                next++;
            }

            res=next;
        }else{
            int swap=dp(index-1,curr^1,1,memo,s)+1;
            int take=dp(index-1,curr,1,memo,s);


            res=Math.min(swap,take);
        }
        



        return memo[index][prev][type]=res;
    }




    public int minChanges(String s) {
        int size=s.length();

        int[][][] memo=new int[size][2][2];

        for(int i[][]:memo){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }

        int start=s.charAt(size-1)-'0';
        int take=dp(size-2,start,1,memo,s);
        int swap=dp(size-2,start^1,1,memo,s)+1;

        // System.out.println(take+" : "+swap);
        return Math.min(take,swap);
    }
}