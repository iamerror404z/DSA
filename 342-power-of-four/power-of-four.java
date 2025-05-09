class Solution {
    public boolean isPowerOfFour(int n) {
        // if(n==1){return true;}
        if(n==0){return false;}
        int b = n;
        int ic = n;
        double dc = n;
        while (ic == dc && b!=1) {
            ic = b / 4;
            dc = (float) b / 4;
            b = b / 4;
        }
        return dc == 1;
    }
}
