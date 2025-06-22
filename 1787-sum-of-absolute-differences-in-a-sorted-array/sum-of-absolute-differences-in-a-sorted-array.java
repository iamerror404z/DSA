class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len=nums.length;
        int[] preSum=new int[len];
        int[] postSum=new int[len];
        
        for(int i=1;i<len;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
        }

        for(int i=len-2;i>=0;i--){
            postSum[i]=postSum[i+1]+nums[i+1];
        }

        int[] ans=new int[len];
        len--;
        
        for(int i=0;i<=len;i++){
            ans[i]=Math.abs((i*nums[i])-preSum[i])+Math.abs(((len-i)*nums[i])-postSum[i]);
        }
        

        return  ans;
        
    }
}