class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length=nums.length;

        long sum=0;
        int index=0;

        while(index<length && sum<target){
            sum+=nums[index];
            index++;
        }

        if(sum<target){
            return 0;
        }

       int min=index;
    
       if(sum>target){
        sum-=nums[--index];
       }

        int start=0;

        for(int i=index;i<length;i++){
            sum+=nums[i];

            while(start<i && sum>target){
                sum-=nums[start];
                start++;
            }

            if(sum<target){
                sum+=nums[--start];
            }
                min=Math.min(i-start+1,min);

        }


        return min;
        
    }
}