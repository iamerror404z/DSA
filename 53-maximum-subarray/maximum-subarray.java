class Solution {
    public int maxSubArray(int[] nums) {
        int start=0;
        int sum=0;
        int size=nums.length;
        int max=nums[0];

        for(int i=0;i<size;i++){
            sum+=nums[i];
            
            if(sum<=0){
                start=i+1;
                max=Math.max(max,sum);
                sum=0;
            }else{
                max=Math.max(max,sum);
            }


        }

        
            return max;
    }
}