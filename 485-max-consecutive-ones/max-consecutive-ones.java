class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=Integer.MIN_VALUE;
        int comp=0;
        for(int ii:nums){
            if(ii==1){
                comp++;}
            else{
                if (comp>max){max=comp;}
                comp=0; }}
        if(comp>max){max=comp;}        
        return max;}
}