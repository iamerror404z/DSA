class Solution {
    public int countDigits(int num) {
        int ans=0,b=num;
        while(b!=0){
            int dg=b%10;
            if(num%dg==0){ans++;}
            b/=10;}
        return ans;
        
    }
}