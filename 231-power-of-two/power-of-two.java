class Solution {
    public boolean isPowerOfTwo(int n) {
        double f=(double) n;
        int i=n;
        if(n==0){
            return false;
        }while(f==i && f!=1){
            f=f/2;
            i=i/2;
        }if(f==1){
            return true;
        }
        return false;
    }
}