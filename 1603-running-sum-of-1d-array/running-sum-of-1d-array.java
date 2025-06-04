class Solution {
    public int[] runningSum(int[] nums) {
        int len=nums.length;
        int[] sum=new int[len];
        if(len==1){
            return nums;
        }
        sum[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }
        
        return sum;
    }
}