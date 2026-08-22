class Solution {
    public boolean checkDivisibility(int n) {
        int b=0;
        b=n;
        int sum=0;
        int fact=1;
        while(b!=0){
            int digit=(b%10);
            fact*=digit;
                b/=10;
            sum+=digit;
        }

        return 0==n%(sum+fact);
    }
}