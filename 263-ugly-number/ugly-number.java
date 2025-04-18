class Solution {
  public boolean isUgly(int n) {
    int m=n;
    int c=1;
    if(n<=0){return false;}
    while(c!=0){
        c=0;
        if(m%2==0){m/=2;c++;}
        if(m%3==0){m/=3;c++;}
        if(m%5==0){m/=5;c++;}
        System.out.println(m+" "+c);
    }
        return m==1;}

}