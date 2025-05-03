class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int s:nums){
            int b=s;
            int step=0;
            while(b!=0){
                step+=(b%10);
                b/=10;
            }if(step<min){
                min=step;
            }
        }
        return min;
    }
}