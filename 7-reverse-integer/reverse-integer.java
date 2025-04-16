import java.math.*;

class Solution {
    public int reverse(int x) {
        long ans=0;
        int fin=0;
        int digit=0;
        int temp=x;
        while(temp!=0){
            digit=temp%10;
            ans+=digit;
            ans*=10;
            temp/=10;}ans/=10;
    int limit=(int) Math.pow(2,31)*-1;
    int max=(int) Math.pow(2,31)-1;
    if(ans<limit || ans>max){
        return 0;}
    fin=(int)ans;
     return fin; } 
    }