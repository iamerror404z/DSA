class Solution {
    public int maxProduct(int n) {
        int mx1=-1,mx2=-1;
        int b=n;
        while(b!=0){
            int dg=b%10;
            b/=10;
            boolean trigg=true;
            if(dg>mx1){
                trigg=false;
                mx2=mx1;
                mx1=dg;
            }
            // System.out.println(mx1+" "+mx2);
            if(trigg && dg>mx2){
                mx2=dg;
            }
        }
        return mx1*mx2;
    }
}