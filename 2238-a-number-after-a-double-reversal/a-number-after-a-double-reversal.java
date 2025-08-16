class Solution {
    public boolean isSameAfterReversals(int num) {
        int rev1=0;
        int b=num;

        while(b!=0){
            rev1+=(b%10);
            rev1*=10;
            b/=10;
        }
        int rev2=0;
        rev1/=10;
        b=rev1;
        while(b!=0){
            rev2+=(b%10);
            rev2*=10;
            b/=10;
        }
        rev2/=10;
        
        return num==rev2;
    }
}