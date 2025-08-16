class Solution {
    public int maximum69Number (int num) {
        int rev=0;
        int changes=0;
        int b=num;
        int len=(""+num).length();
        while(b!=0){
            rev+=(b%10);
            rev*=10;
            b/=10;
        }
        b=rev/10;
        int res=0;
        int  d=0;
        while(b!=0){
            d=(b%10);
            if(d==6 && changes==0){
                res+=9;
                changes++;
            }else{
                res+=d;

            }
            res*=10;
            b/=10;
        }

       
       return res/10;
    }
}