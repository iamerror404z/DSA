class Solution {
    public int productDigit(int num){
        int res=1;

        while(num!=0){
            int curr=num%10;

            if(curr==0){
                return 0;
            }
            res*=curr;


            num/=10;
        }

        return res;

    }

    public int smallestNumber(int n, int t) {
        int times=10-(n%10);

        for(int i=n;i<n+times;i++){
            if(productDigit(i)%t==0){
                return i;
            }
        }

        return n+times;
    }
}