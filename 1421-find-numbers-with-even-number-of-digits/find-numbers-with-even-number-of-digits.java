class Solution {
    public int findNumbers(int[] nums) {
        int ans=0;
        for(int ii:nums){
        int len=0;
        int b=ii;
        while(b!=0){
            len++;
            b/=10;
        }
        if(len%2==0){
            ans++;
        }}
        return ans+00;
    }
}