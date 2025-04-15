class Solution {
    public int addDigits(int num) {
        int sum=0,temp=100;
        int b=num,digit=0;
        while (temp>9){
            while(b!=0){
                digit=b%10;
                sum+=digit;
                b/=10;
            }if(sum<=9 && sum>=0){
                temp=1;
                break;}
                b=sum;
             sum=0;}
            return sum;
    }
}