class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int b=x;
        int sum=0;
        int digit=0;
        while(b!=0){
            digit=b%10;
            sum+=digit;
            //sum*=10;
            b/=10;
        };
        System.out.println(sum);
        if(x%sum==0){
            return sum;
        }return -1;
    }
}