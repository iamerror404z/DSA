class Solution {

    public boolean isValid(int left,int right,String s){
        if(left<0 || right>=s.length()){

            return false;
        }

        return true;
    }


    public int[] expand(int left,int right,String s){
        int[] res={0,0};


        while(isValid(left,right,s) && s.charAt(left)==s.charAt(right)){
            res[0]=left;
            res[1]=right;


            left--;
            right++;
        }

        if(res[0]==res[1] && res[0]==0){
            res[0]=left;
            res[1]=left+1;
        }else{


        res[1]++;}

        return res;
    }

    public String longestPalindrome(String s) {
        int res[]=new int[2];
        res[1]++;
        int n=s.length();
        

        for(int i=1;i<n;i++){
            int[] currOdd=expand(i,i,s);
            int[] currEven=expand(i-1,i,s);

            int[] curr=currEven;


            if(currOdd[1]-currOdd[0]>currEven[1]-currEven[0]){
                curr=currOdd;
            }

            int currLen=curr[1]-curr[0];
            int prevLen=res[1]-res[0];


            if(currLen>prevLen){
                res[0]=curr[0];
                res[1]=curr[1];
            }



        }


        return s.substring(res[0],res[1]);
    }
}